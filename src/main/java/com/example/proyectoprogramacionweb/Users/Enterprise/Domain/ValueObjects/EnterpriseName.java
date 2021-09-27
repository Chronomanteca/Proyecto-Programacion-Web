package com.example.proyectoprogramacionweb.Users.Enterprise.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.StringValueObject;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.Enterprise;

public class EnterpriseName extends StringValueObject {
    private EnterpriseName(){}
    public EnterpriseName(String name){
        validate(name);
        this.value = name;
    }

    private void validate(String name) {
        //TODO: Validar nombre de la inmobiliaria
    }
}
