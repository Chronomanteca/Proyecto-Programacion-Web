package com.example.proyectoprogramacionweb.Estates.Estate.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Exceptions.InvalidEstateBathroomNumber;
import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.IntegerValueObject;

public class EstateBathroomNumber extends IntegerValueObject {
    private EstateBathroomNumber(){}
    public EstateBathroomNumber(Integer bathroomNumber) {
        validate(bathroomNumber);
        this.value = bathroomNumber;
    }

    private void validate(Integer bathroomNumber) {
        if(bathroomNumber.compareTo(0) <= 0 )
            throw new InvalidEstateBathroomNumber("El inmueble debe tener por lo menos un baño");
    }
}
