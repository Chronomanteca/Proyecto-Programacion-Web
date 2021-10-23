package com.example.proyectoprogramacionweb.Shared.Domain.Exceptions;

public class PasswordNotValid extends RuntimeException{
    public PasswordNotValid(String message) {
        super(message);
    }
}
