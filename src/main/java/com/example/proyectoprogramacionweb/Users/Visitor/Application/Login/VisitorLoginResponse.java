package com.example.proyectoprogramacionweb.Users.Visitor.Application.Login;

import java.util.HashMap;

public class VisitorLoginResponse {

    private final String userMail;
    private final String token;

    public VisitorLoginResponse(String userMail, String token) {
        this.userMail = userMail;
        this.token = token;
    }

    public HashMap<String, Object> response(){
        HashMap<String, Object> data = new HashMap<>();
        data.put("userName",userMail);
        data.put("token",token);
        return data;
    }

}

