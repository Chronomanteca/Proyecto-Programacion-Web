package com.example.proyectoprogramacionweb.Users.Enterprise.Domain.Exceptions;

public class EnterpriseAlreadyExists extends RuntimeException {
    public EnterpriseAlreadyExists(String message) {
        super(message);
    }
}
