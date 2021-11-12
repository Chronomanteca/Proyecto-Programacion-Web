package com.example.proyectoprogramacionweb.Estates.Estate.Domain.Exceptions;

public class EstateNotFound extends RuntimeException {
    public EstateNotFound(String message) {
        super(message);
    }
}
