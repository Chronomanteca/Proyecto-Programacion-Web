package com.example.proyectoprogramacionweb.Users.Enterprise.Domain.Exceptions;

public class EnterpriseNotFound extends  RuntimeException{
    public EnterpriseNotFound(String message) {
        super(message);
    }
}
