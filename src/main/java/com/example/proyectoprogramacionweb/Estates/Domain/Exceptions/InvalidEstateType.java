package com.example.proyectoprogramacionweb.Estates.Domain.Exceptions;

public class InvalidEstateType extends RuntimeException {
    public InvalidEstateType(String message) {
        super(message);
    }
}
