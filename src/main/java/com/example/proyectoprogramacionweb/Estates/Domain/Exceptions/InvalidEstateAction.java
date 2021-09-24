package com.example.proyectoprogramacionweb.Estates.Domain.Exceptions;

public class InvalidEstateAction extends RuntimeException {
    public InvalidEstateAction(String message) {
        super(message);
    }
}
