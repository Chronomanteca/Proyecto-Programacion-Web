package com.example.proyectoprogramacionweb.Estates.Estate.Domain.Exceptions;

public class InvalidEstateDescription extends RuntimeException {
    public InvalidEstateDescription(String message) {
        super(message);
    }
}
