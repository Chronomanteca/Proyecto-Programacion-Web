package com.example.proyectoprogramacionweb.Users.Visitor.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.IntegerValueObject;
import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.LongValueObject;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.Exceptions.InvalidVisitorPhoneNumber;

public class VisitorPhoneNumber extends LongValueObject {
    private VisitorPhoneNumber() {}
    public VisitorPhoneNumber(Long phoneNumber){
        validate(phoneNumber);
        this.value = phoneNumber;
    }

    private void validate(Long phoneNumber) {
        phoneNumberLength(phoneNumber);
    }

    private void phoneNumberLength(Long phoneNumber){
        int length = (int) (Math.log10(phoneNumber) + 1);
        if(length != 10){
            throw new InvalidVisitorPhoneNumber("El numero de telefono ingresado debe tener 10 digitos");
        }

    }
}
