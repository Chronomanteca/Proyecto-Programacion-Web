package com.example.proyectoprogramacionweb.Shared.Infrastructure.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //TODO: Add proper paths
    private static final String[] AUTH_WHITELIST = {
            "/v3/api-doc/**",
            "/v3/api-doc.yaml/**",
            "/swagger-ui/**",
            "/visitors/**",
            "/search/",
            "/",
            "/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().
            addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class).
                authorizeRequests().
                antMatchers(HttpMethod.POST, "/User/Login").permitAll().
                antMatchers(HttpMethod.POST, AUTH_WHITELIST).permitAll().
                antMatchers(HttpMethod.GET, AUTH_WHITELIST).permitAll().
                antMatchers(HttpMethod.PUT, AUTH_WHITELIST).permitAll().
                antMatchers(HttpMethod.DELETE, AUTH_WHITELIST).permitAll().
                anyRequest().authenticated();
    }

}
