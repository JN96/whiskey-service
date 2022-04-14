package com.assignment.whiskeyapi.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    final static String API = "/whiskeyapi/api/**";
    final static String ADMIN_ROLE = "ADMIN";

    @Override
    public void configure(final HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers(HttpMethod.GET, API).hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.POST, API).hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.PUT, API).hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE, API).hasRole(ADMIN_ROLE)
                .anyRequest().authenticated();
    }

}
