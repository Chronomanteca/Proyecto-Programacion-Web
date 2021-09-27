package com.example.proyectoprogramacionweb.Users.Visitor.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.IntegerValueObject;

public class VisitorPhoneNumber extends IntegerValueObject {
    private VisitorPhoneNumber() {}
    public VisitorPhoneNumber(Integer phoneNumber){
        validate(phoneNumber);
        this.value = phoneNumber;
    }

    private void validate(Integer phoneNumber) {
        //TODO: Validar el celular del visitante
    }
}
