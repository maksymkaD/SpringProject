package com.example.application.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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

    @Value("${password.teacher}")
    private String pass_t;

    @Value("${uname.admin}")
    private String name_a;

    @Value("${uname.user}")
    private String name_u;

    @Value("${uname.teacher}")
    private String name_t;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser(name_u).
                password(passwordEncoder().encode(pass_u)).roles(Roles.STUDENT.toString());

        auth.inMemoryAuthentication().withUser(name_a).
                password(passwordEncoder().encode(pass_a)).roles(Roles.ADMIN.toString());

        auth.inMemoryAuthentication().withUser(name_t).
                password(passwordEncoder().encode(pass_t)).roles(Roles.TEACHER.toString());

    }

    @Bean
    public PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterAfter(new CustomFilter(), BasicAuthenticationFilter.class);
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/").hasAnyRole(Roles.TEACHER.toString(),Roles.STUDENT.toString(),Roles.ADMIN.toString())
                .antMatchers(HttpMethod.POST,"/subjects/**").hasRole(Roles.TEACHER.toString())
                .antMatchers(HttpMethod.DELETE,"/subject/**").hasRole(Roles.TEACHER.toString())
                .antMatchers(HttpMethod.POST,"/lessons/**").hasRole(Roles.TEACHER.toString())
                .antMatchers(HttpMethod.DELETE,"/lesson/**").hasRole(Roles.TEACHER.toString())
                .antMatchers(HttpMethod.POST).hasRole(Roles.ADMIN.toString())
                .antMatchers(HttpMethod.DELETE).hasRole(Roles.ADMIN.toString())
                .antMatchers("/admin/**").hasRole(Roles.ADMIN.toString())
                .antMatchers("/h2-ui/**").hasRole(Roles.ADMIN.toString())
                .and().formLogin();
//        UNCOMMENT THIS IF YOU WANT TO USE H2-CONSOLE
//        http.csrf().disable();
//        http.headers().frameOptions().disable();

    }
}

