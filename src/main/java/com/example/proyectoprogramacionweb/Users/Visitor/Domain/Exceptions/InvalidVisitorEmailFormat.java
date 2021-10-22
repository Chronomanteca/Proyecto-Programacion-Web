package com.example.proyectoprogramacionweb.Users.Visitor.Domain.Exceptions;

public class InvalidVisitorEmailFormat extends RuntimeException{
    public InvalidVisitorEmailFormat(String message) {
        super(message);
    }
}
