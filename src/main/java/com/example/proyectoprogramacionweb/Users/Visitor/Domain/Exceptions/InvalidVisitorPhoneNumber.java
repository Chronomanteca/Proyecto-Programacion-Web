package com.example.proyectoprogramacionweb.Users.Visitor.Domain.Exceptions;

public class InvalidVisitorPhoneNumber extends RuntimeException{
    public InvalidVisitorPhoneNumber(String message) {
        super(message);
    }
}
