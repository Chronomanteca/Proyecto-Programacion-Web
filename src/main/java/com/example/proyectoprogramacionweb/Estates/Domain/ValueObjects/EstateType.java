package com.example.proyectoprogramacionweb.Estates.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Estates.Domain.Exceptions.InvalidEstateType;
import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.StringValueObject;

public class EstateType extends StringValueObject {
    private EstateType(){}
    public EstateType(String type) {
        validate(type);
        this.value = type;
    }

    private void validate(String type) {
        if(!type.equals("house") && !type.equals("apartment") && !type.equals("office") &&
                !type.equals("studio apartment") && !type.equals("shop")){
            throw new InvalidEstateType("The Estate type can only be house, apartment, office, studio apartment or shop");
        }
    }
}
