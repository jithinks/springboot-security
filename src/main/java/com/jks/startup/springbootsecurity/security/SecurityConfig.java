package com.jks.startup.springbootsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
//The @EnableWebSecurity annotation is crucial if we disable the default security configuration.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${special.user}")
    private String SPECIAL_USER;

    @Value("${special.pass}")
    private String SPECIAL_PASS;

    // Authentication : User --> Roles
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(
                org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance())
                .withUser("jack").password("secret").roles("REST-USER").and()
                .withUser("admin").password("very-secret").roles("REST-USER", "ADMIN").and()
                .withUser(SPECIAL_USER).password(SPECIAL_PASS).roles("REST-USER", "ADMIN");
    }

    // Authorization : Role -> Access
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers("/team/**").hasRole("REST-USER")
                .antMatchers("/topic/**").hasRole("REST-USER")
                .antMatchers("/**").hasRole("ADMIN").and()
                .csrf().disable().headers().frameOptions().disable();
    }

}
