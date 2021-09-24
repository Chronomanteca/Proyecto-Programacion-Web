package com.example.proyectoprogramacionweb.Estates.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Estates.Domain.Exceptions.InvalidEstateAction;
import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.StringValueObject;

public class EstateAction extends StringValueObject {
    private EstateAction(){}
    public EstateAction(String action) {
        validate(action);
        this.value = action;
    }

    private void validate(String action) {
        if(!action.equals("rentar") && !action.equals("vender")){
            throw new InvalidEstateAction("La accion del inmueble debe ser rentar o vender");
        }
    }
}