package com.example.proyectoprogramacionweb.Shared.Application;

public class TokenGenerationResponse {

    private final String token;

    public TokenGenerationResponse(String token) {
        this.token = token;
    }
    public String token(){
        return this.token;
    }
}
