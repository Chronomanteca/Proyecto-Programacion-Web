package com.example.proyectoprogramacionweb.Users.Visitor.Domain.Exceptions;

public class InvalidVisitorName extends RuntimeException{
    public InvalidVisitorName(String message) {
        super(message);
    }
}
