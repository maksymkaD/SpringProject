package com.example.application.security.transport;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Component
public class RequestFilter extends GenericFilterBean {

    @Override
    public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("Remote Host:"+request.getRemoteHost());
        System.out.println("Remote Address:"+request.getRemoteAddr());

        /*
            DON`T remove this line
         */
        chain.doFilter(request, response);

        System.out.println("Response content type:"+response.getContentType());
        System.out.println("Response encoding:"+response.getCharacterEncoding());
    }
}