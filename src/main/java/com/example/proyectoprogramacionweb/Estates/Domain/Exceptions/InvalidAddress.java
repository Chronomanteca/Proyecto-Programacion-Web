package com.example.proyectoprogramacionweb.Estates.Domain.Exceptions;

public class InvalidAddress extends RuntimeException{
    public InvalidAddress(String message) {
        super(message);
    }

}
