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
            "/search",
            "/search/form"
    };

    private static final String[] AUTH_VISITOR_GET = {
            "/visitors/{{visitorId}}/appointments"

    };
    private static final String[] AUTH_ENTERPRISE_GET = {
            "/enterprises/{{enterpriseId}}/appointments",
            "/estates/{{estateId}}"
    };

    private static final String[] AUTH_ENTERPRISE_POST = {
            "/enterprise/{{enterpriseId}}/appointments/appointment",
            "/enterprises/{{enterpriseId}}/properties"

    };
    private static final String[] AUTH_ENTERPRISE_PUT = {
            "enterprises/{{enterpriseId}}/properties/{{estateId}}/"

    };
    private static final String[] AUTH_ENTERPRISE_DELETE = {
            "/enterprises/{{enterpriseId}}/properties/{{estateId}}"
    };

    private static final String[] AUTH_WHITELIST_POST = {
            "/enterprises/",
            "/visitors/"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().
            addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class).
                authorizeRequests().
                antMatchers(HttpMethod.POST, "/Login/Visitor").permitAll().
                antMatchers(HttpMethod.POST, "/Login/Enterprise").permitAll().
                antMatchers(HttpMethod.POST, "/visitors").permitAll().
                antMatchers(HttpMethod.POST, "/enterprises").permitAll().
                antMatchers(HttpMethod.GET, AUTH_VISITOR_GET).hasAnyAuthority("ROLE_VISITOR").
                antMatchers(HttpMethod.GET, AUTH_ENTERPRISE_GET).hasAnyAuthority("ROLE_ENTERPRISE").
                antMatchers(HttpMethod.POST, AUTH_ENTERPRISE_POST).hasAnyAuthority("ROLE_ENTERPRISE").
                antMatchers(HttpMethod.PUT, AUTH_ENTERPRISE_PUT).hasAnyAuthority("ROLE_ENTERPRISE").
                antMatchers(HttpMethod.DELETE, AUTH_ENTERPRISE_DELETE).hasAnyAuthority("ROLE_ENTERPRISE").
                antMatchers(HttpMethod.POST, AUTH_WHITELIST_POST).permitAll().
                antMatchers(HttpMethod.GET, AUTH_WHITELIST).permitAll().
                anyRequest().authenticated();
    }

}
