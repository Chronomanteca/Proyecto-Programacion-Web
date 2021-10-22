package com.example.proyectoprogramacionweb.Users.Visitor.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.StringValueObject;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.Exceptions.InvalidVisitorEmailFormat;

import java.util.regex.Pattern;

public class VisitorEmail extends StringValueObject {
    private VisitorEmail() {}
    public VisitorEmail(String email){
        validate(email);
        this.value = email;
    }

    private void validate(String email) {
        emailFormat(email);
    }

    private void emailFormat(String email){
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        if(!Pattern.matches(email,"")){
            throw new InvalidVisitorEmailFormat("El email ingresado no tiene un formato valido");
        }
    }
}
