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
    @Autowired
    private AdministratorRepository adminRepo;
    
    //configures all the admin and customers auth in the Kasebot app
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
            System.out.println("UserName = " + i.getLoginName() + " PW="+i.getPassword());
            auth.inMemoryAuthentication().withUser(i.getLoginName()).password((i.getPassword())).roles("ADMIN");
        }
    }
  
    @Override 
    protected void configure(HttpSecurity http) throws Exception {    
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


