package com.example.proyectoprogramacionweb.Estates.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.StringValueObject;

public class EstateDescription extends StringValueObject {
    private EstateDescription(){}
    public EstateDescription(String description){
        validate(description);
        this.value = description;
    }

    private void validate(String description) {
        //TODO: Validar descripcion del inmueble
    }
}
