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
import io.swagger.model.User;
import io.swagger.model.UserCustRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserCustRepository userCustRepository;
    
    //users configuration
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
        /*List<User> custList = Lists.newArrayList(userCustRepository.findAll());
        for(E element: custList){
            auth.inMemoryAuthentication().withUser(element.getEmail()).password((element.getPassword())).roles("USER");
        }*/
        
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
    }
  
    @Override protected void configure(HttpSecurity http) throws Exception {    
      http.httpBasic().
        realmName("spring-app").
        and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
        and().csrf().disable().
        authorizeRequests().anyRequest().fullyAuthenticated().and().
        httpBasic();
    }


   @Bean
    public NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

}


