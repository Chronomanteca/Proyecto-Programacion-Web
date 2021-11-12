package com.example.proyectoprogramacionweb.Estates.Estate.Domain.Exceptions;

public class InvalidEstateAction extends RuntimeException {
    public InvalidEstateAction(String message) {
        super(message);
    }
}
