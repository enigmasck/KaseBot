/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.configuration;
    
/**
 *
 * @author enigmasck
 */

import com.google.common.collect.Lists;
import io.swagger.model.Administrator;
import io.swagger.model.AdministratorRepository;
import io.swagger.model.User;
import io.swagger.model.UserCustRepository;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@SuppressWarnings("deprecation")
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserCustRepository userCustRepository;
    @Autowired
    private AdministratorRepository adminRepo;
    
    /*
    Purpose: configures all the admin and customers auth in the Kasebot app. Gets
    all users and admins from the database and sets up their username, password,
    and roles for basic authentication. 
    */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
        //Set authentication for all users in the DB
        List<User> custList = Lists.newArrayList(userCustRepository.findAll());
        for(User i: custList){
            auth.inMemoryAuthentication().withUser(i.getEmail()).password((i.getPassword())).roles("USER");
        }
        //Set auth for admin in the DB
        List<Administrator> adminList = Lists.newArrayList(adminRepo.findAll());
        for(Administrator i: adminList){
            //System.out.println("UserName = " + i.getLoginName() + " PW="+i.getPassword());
            auth.inMemoryAuthentication().withUser(i.getLoginName()).password((i.getPassword())).roles("ADMIN");
        }
    }
    /*
    Purpose: This is required for CORS. Spring boot enables it by default, 
    and it automatically applies the same-origin policy, which prevents javascript
    from running from a different domain.
    We set ours to allow all since our API could be implmented as a public API.
    It would need to allow any origin to access it.
    */
    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(Boolean.TRUE);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    /*
    Purpose: This method is what configures the spring security. We choose to implement
    security in this fashion as opposed to using @Preauthorize or @Secured annotations
    at the class/controller level because it's one central location for securing the
    webapp. As the application grows it would become harder to manage all the locations of the 
    security. Whereas all security configurations can be found here. Although there are a couple caveats:
    
    We had to disable the csfr, by using csrf().disable().
    Orderin the antMatchers is very important. It has to be done in order. It's also important
    to understand how the spring boot precendence of security works. The anyRequest().fullyAuthenticated()
    is applied first before any other permissions. So if you require fullyAuthenticated, then 
    permitAll will not work for users that are not authenticated even though it 
    applys permitAll for the specifc HttpMethod and resource. 
    */
    @Override 
    protected void configure(HttpSecurity http) throws Exception {    

        http.httpBasic().
        realmName("spring-app").
        and().cors().
        and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS).
        and().csrf().disable().
        authorizeRequests().//.anyRequest().fullyAuthenticated().
            antMatchers("/admins/**").hasAnyRole("ADMIN").
            antMatchers("/reports/**").hasAnyRole("ADMIN").
            antMatchers(HttpMethod.POST,"/customers").permitAll().
            antMatchers(HttpMethod.DELETE,"/customers/**").hasAnyRole("ADMIN","USER").
            antMatchers(HttpMethod.PUT,"/customers/**").hasAnyRole("ADMIN","USER").
            antMatchers(HttpMethod.GET,"/customers").hasAnyRole("ADMIN").
            antMatchers(HttpMethod.GET,"/customers/**").hasAnyRole("ADMIN","USER").
            antMatchers(HttpMethod.GET,"/chat/**").hasAnyRole("ADMIN","USER").
            antMatchers(HttpMethod.POST,"/chat/sub").permitAll()           
        .and().httpBasic()
        .and()
        .formLogin()
        .loginPage("/login.html")
        .loginProcessingUrl("/perform_login")
        .defaultSuccessUrl("/homepage.html", true)
        .and()
        .logout()
        .logoutUrl("/perform_logout")
        .deleteCookies("JSESSIONID");
      
    }


   @Bean
    public NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

}


