package com.example.proyectoprogramacionweb.Shared.Application;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.config.web.servlet.oauth2.resourceserver.JwtDsl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TokenGeneration  {

    private final String HEADER = "token";
    private final String PREFIX = "Bearer ";
    private final String SECRET = "SAI";
    private final String CLAIM = "authorities";
    private final String ID = "EstateManagementSystem";
    private final int  validity  = 300000;

    public TokenGeneration() {
    }

    public TokenGenerationResponse execute(String username, String authorities){
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(authorities);
        String token = Jwts.builder()
                .setId(ID)
                .setSubject(username)
                .claim(CLAIM, grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+validity))
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes()).compact();
        return new TokenGenerationResponse(PREFIX+token);

    }


}
