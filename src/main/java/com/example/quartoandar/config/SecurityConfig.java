package com.example.quartoandar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // Authentication : User --> Roles
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth. inMemoryAuthentication().withUser("eduardo").password("{noop}1234")
                .roles("LOCATARIO").and().withUser("edi").password("{noop}4321")
                .roles("LOCADOR", "LOCATARIO");
    }

    // Authorization : Role -> Access
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests().antMatchers("/users/**","/estates")
                .hasRole("LOCATARIO").antMatchers("/**").hasRole("LOCADOR").and()
                .csrf().disable().headers().frameOptions().disable();
    }

}
