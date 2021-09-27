package com.example.proyectoprogramacionweb.Estates.Domain.Exceptions;

public class EstateNotFoundByCity extends RuntimeException {
    public EstateNotFoundByCity(String message) {
        super(message);
    }
}
