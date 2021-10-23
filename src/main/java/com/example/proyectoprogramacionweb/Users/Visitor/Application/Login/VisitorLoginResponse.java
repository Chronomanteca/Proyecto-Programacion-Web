package com.example.proyectoprogramacionweb.Users.Visitor.Application.Login;

import java.util.HashMap;

public class VisitorLoginResponse {

    private final String userName;
    private final String token;

    public VisitorLoginResponse(String userName, String token) {
        this.userName = userName;
        this.token = token;
    }

    public HashMap<String, Object> response(){
        HashMap<String, Object> data = new HashMap<>();
        data.put("userName",userName);
        data.put("token",token);
        return data;
    }

}

