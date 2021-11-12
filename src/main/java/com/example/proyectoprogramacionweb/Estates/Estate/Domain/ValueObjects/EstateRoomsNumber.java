package com.example.proyectoprogramacionweb.Estates.Estate.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Exceptions.InvalidEstateRoomsNumber;
import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.IntegerValueObject;

public class EstateRoomsNumber extends IntegerValueObject {
    private EstateRoomsNumber(){}
    public EstateRoomsNumber(Integer roomsNumber) {
        validate(roomsNumber);
        this.value = roomsNumber;
    }

    private void validate(Integer roomsNumber) {
        if(roomsNumber.compareTo(0) <= 0)
            throw new InvalidEstateRoomsNumber("El inmueble debe tener por lo menos un cuarto");
    }
}
