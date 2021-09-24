package com.example.proyectoprogramacionweb.Estates.Domain.Exceptions;

public class InvalidEstatePrice extends RuntimeException {
    public InvalidEstatePrice(String message) {
        super(message);
    }
}
