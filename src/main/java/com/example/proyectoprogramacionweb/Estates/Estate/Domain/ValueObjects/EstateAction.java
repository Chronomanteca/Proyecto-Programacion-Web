package com.example.proyectoprogramacionweb.Estates.Estate.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Exceptions.InvalidEstateAction;
import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.StringValueObject;

public class EstateAction extends StringValueObject {
    private EstateAction(){}
    public EstateAction(String action) {
        validate(action);
        this.value = action;
    }

    private void validate(String action) {
        if(!action.equals("rent") && !action.equals("sell")){
            throw new InvalidEstateAction("La accion del inmueble debe ser 'rent' o 'sell'");
        }
    }
}
