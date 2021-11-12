package com.example.proyectoprogramacionweb.Estates.Estate.Domain.Exceptions;

public class EstateAlreadyExists extends RuntimeException {
    public EstateAlreadyExists(String message) {
        super(message);
    }
}
