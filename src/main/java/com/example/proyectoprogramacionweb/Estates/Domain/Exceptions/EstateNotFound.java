package com.example.proyectoprogramacionweb.Estates.Domain.Exceptions;

public class EstateNotFound extends RuntimeException {
    public EstateNotFound(String message) {
        super(message);
    }
}
