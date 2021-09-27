package com.example.proyectoprogramacionweb.Users.Visitor.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.StringValueObject;

public class VisitorName extends StringValueObject {
    private VisitorName() {}
    public VisitorName(String name){
        validate(name);
        this.value = name;
    }

    private void validate(String name) {
        //TODO: Validar el nombre del visitante
    }
}
