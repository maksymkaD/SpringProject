package com.example.application.security;

import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new MyUserDetailsService();
    }

    @Bean
    public MyPasswordEncoder passwordEncoder() {
        return new MyPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/teachers").hasAnyAuthority("admin", "teacher", "student")
                .antMatchers(HttpMethod.GET, "/teachers/create").hasAnyAuthority("admin")
                .antMatchers(HttpMethod.POST, "/teachers/create").hasAnyAuthority("admin")
                .antMatchers(HttpMethod.GET, "/teachers/update").hasAnyAuthority("admin")
                .antMatchers(HttpMethod.POST, "/teachers/update").hasAnyAuthority("admin")
                .antMatchers(HttpMethod.GET, "/teachers/delete").hasAnyAuthority("admin");

        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/students").hasAnyAuthority("admin", "teacher", "student")
                .antMatchers(HttpMethod.GET, "/students/create").hasAnyAuthority("admin")
                .antMatchers(HttpMethod.POST, "/students/create").hasAnyAuthority("admin")
                .antMatchers(HttpMethod.GET, "/students/update").hasAnyAuthority("admin")
                .antMatchers(HttpMethod.POST, "/students/update").hasAnyAuthority("admin")
                .antMatchers(HttpMethod.GET, "/students/delete").hasAnyAuthority("admin");

        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/subjects").hasAnyAuthority("admin", "teacher", "student")
                .antMatchers(HttpMethod.GET, "/subjects/create").hasAnyAuthority("teacher")
                .antMatchers(HttpMethod.POST, "/subjects/create").hasAnyAuthority("teacher")
                .antMatchers(HttpMethod.GET, "/subjects/update").hasAnyAuthority("teacher")
                .antMatchers(HttpMethod.POST, "/subjects/update").hasAnyAuthority("teacher")
                .antMatchers(HttpMethod.GET, "/subjects/delete").hasAnyAuthority("teacher");

        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/lessons").hasAnyAuthority("admin", "teacher", "student")
                .antMatchers(HttpMethod.GET, "/lessons/create").hasAnyAuthority("admin","teacher")
                .antMatchers(HttpMethod.POST, "/lessons/create").hasAnyAuthority("admin","teacher")
                .antMatchers(HttpMethod.GET, "/lessons/update").hasAnyAuthority("admin","teacher")
                .antMatchers(HttpMethod.POST, "/lessons/update").hasAnyAuthority("admin","teacher")
                .antMatchers(HttpMethod.GET, "/lessons/delete").hasAnyAuthority("admin","teacher");

        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/").hasAnyAuthority("admin", "teacher", "student")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll();
    }
}