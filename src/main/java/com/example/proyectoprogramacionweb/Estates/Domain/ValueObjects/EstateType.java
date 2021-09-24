package com.example.proyectoprogramacionweb.Estates.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.StringValueObject;

public class EstateType extends StringValueObject {
    private EstateType(){}
    public EstateType(String type) {
        validate(type);
        this.value = type;
    }

    private void validate(String type) {
        //TODO: validacion para tipo de inmueble
    }
}
