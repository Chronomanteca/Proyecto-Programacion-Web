package com.example.proyectoprogramacionweb.Estates.Estate.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Exceptions.InvalidEstatePrice;
import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.DoubleValueObject;

public class EstatePrice extends DoubleValueObject {
    private EstatePrice(){}
    public EstatePrice(Double price) {
        validate(price);
        this.value = price;
    }

    private void validate(Double price) {
        if(price.compareTo(0d) <= 0)
            throw new InvalidEstatePrice("El precio de un inmueble debe ser mayor a cero");
    }
}
