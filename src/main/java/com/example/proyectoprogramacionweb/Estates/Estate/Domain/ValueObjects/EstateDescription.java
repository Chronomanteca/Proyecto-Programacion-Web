package com.example.proyectoprogramacionweb.Estates.Estate.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Exceptions.InvalidEstateDescription;
import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.StringValueObject;

public class EstateDescription extends StringValueObject {
    private EstateDescription(){}
    public EstateDescription(String description){
        validate(description);
        this.value = description;
    }

    private void validate(String description) {
        if(description.length() > 80)
            throw new InvalidEstateDescription("The Estate description can have a maximun of 80 chacarters");
    }
}
