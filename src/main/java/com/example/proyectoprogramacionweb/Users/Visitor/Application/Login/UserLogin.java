package com.example.proyectoprogramacionweb.Users.Visitor.Application.Login;


import com.example.proyectoprogramacionweb.Shared.Application.TokenGeneration;
import com.example.proyectoprogramacionweb.Shared.Application.TokenGenerationResponse;

public class UserLogin {

    private final TokenGeneration tokenGeneration;

    public TokenGeneration getTokenGeneration() {
        return tokenGeneration;
    }

    public UserLogin(TokenGeneration tokenGeneration) {
        this.tokenGeneration = tokenGeneration;
    }

    public UserLoginResponse execute(String username, String password){
        //validate user exists
        //validate correct password
        TokenGenerationResponse responseToken = this.tokenGeneration.execute(username);
        UserLoginResponse response = new UserLoginResponse(username, responseToken.token());
        return response;
        }

}
