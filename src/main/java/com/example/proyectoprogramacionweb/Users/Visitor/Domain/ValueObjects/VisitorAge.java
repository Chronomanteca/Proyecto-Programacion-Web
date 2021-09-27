package com.example.proyectoprogramacionweb.Users.Visitor.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.IntegerValueObject;

public class VisitorAge extends IntegerValueObject {
    private VisitorAge() {}
    public VisitorAge(Integer age){
        validate(age);
        this.value = age;
    }

    private void validate(Integer age) {
        //TODO: Validar la edad del visitante
    }
}
