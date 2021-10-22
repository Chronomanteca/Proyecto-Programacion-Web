package com.example.proyectoprogramacionweb.Users.Visitor.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.IntegerValueObject;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.Exceptions.InvalidVisitorAge;

public class VisitorAge extends IntegerValueObject {
    private VisitorAge() {}
    public VisitorAge(Integer age){
        validate(age);
        this.value = age;
    }

    private void validate(Integer age) {
        validate(age);
    }

    private void ageRange(Integer age){
        if(age<18){
            throw new InvalidVisitorAge("La edad del visitante debe ser mayor o igual a 18 años");

        }
    }
}
