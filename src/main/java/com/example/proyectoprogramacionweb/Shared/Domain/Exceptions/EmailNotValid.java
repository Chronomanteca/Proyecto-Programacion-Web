package com.example.proyectoprogramacionweb.Shared.Domain.Exceptions;

public class EmailNotValid extends RuntimeException{
    public EmailNotValid(String message) {
        super(message);
    }
}
