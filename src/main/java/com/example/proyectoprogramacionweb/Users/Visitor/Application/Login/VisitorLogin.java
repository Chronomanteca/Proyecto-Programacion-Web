package com.example.proyectoprogramacionweb.Users.Visitor.Application.Login;


import com.example.proyectoprogramacionweb.Shared.Application.TokenGeneration;
import com.example.proyectoprogramacionweb.Shared.Application.TokenGenerationResponse;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.Ports.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class VisitorLogin {

    @Autowired
    VisitorRepository repo;

    private final TokenGeneration tokenGeneration;

    public TokenGeneration getTokenGeneration() {
        return tokenGeneration;
    }

    public VisitorLogin(TokenGeneration tokenGeneration) {
        this.tokenGeneration = tokenGeneration;
    }

    public VisitorLoginResponse execute(String username, String password){
        //validate user exists
        //validate correct password
        TokenGenerationResponse responseToken = this.tokenGeneration.execute(username);
        VisitorLoginResponse response = new VisitorLoginResponse(username, responseToken.token());
        return response;
        }




}
