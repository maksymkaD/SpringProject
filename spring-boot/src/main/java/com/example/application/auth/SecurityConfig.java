package com.example.application.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Value("${password.admin}")
    private String pass_a;

    @Value("${password.user}")
    private String pass_u;

    @Value("${uname.admin}")
    private String name_a;

    @Value("${uname.user}")
    private String name_u;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser(name_u).
                password(passwordEncoder().encode(pass_u)).roles(Roles.USER.toString());

        auth.inMemoryAuthentication().withUser(name_a).
                password(passwordEncoder().encode(pass_a)).roles(Roles.ADMIN.toString());

    }

    @Bean
    public PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterAfter(new CustomFilter(), BasicAuthenticationFilter.class);
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole(Roles.USER.toString(),Roles.ADMIN.toString())
                .antMatchers("/admin/**").hasRole(Roles.ADMIN.toString())
                .antMatchers("/h2-ui/**").hasRole(Roles.ADMIN.toString())
                .and().formLogin();
//        UNCOMMENT THIS IF YOU WANT TO USE H2-CONSOLE
//        http.csrf().disable();
//        http.headers().frameOptions().disable();

    }
}

