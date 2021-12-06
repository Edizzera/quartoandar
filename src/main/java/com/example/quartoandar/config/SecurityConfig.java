package com.example.quartoandar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsService userDetailsService;
    //faz parte do springSecurity

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider
                = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }
    //Locador pode cadastrar imóvel
    // Authorization : Role -> Access
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
//                .antMatchers("/").permitAll()

                .antMatchers("/users", "/estates").hasAuthority("LOCATARIO")
                .antMatchers("/users/**","/estates/**").hasAuthority("LOCADOR")


//                .hasAuthority("LOCADOR","LOCATARIO")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    // Authentication : User --> Roles
//    protected void configure(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth. inMemoryAuthentication().withUser("eduardo").password("{noop}1234")
//                .roles("LOCATARIO").and().withUser("edi").password("{noop}4321")
//                .roles("LOCADOR", "LOCATARIO");
//    }

//    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic().and().authorizeRequests().antMatchers("/users/**","/estates")
//                .hasRole("LOCATARIO").antMatchers("/**").hasRole("LOCADOR").and()
//                .csrf().disable().headers().frameOptions().disable();
//    }

}
