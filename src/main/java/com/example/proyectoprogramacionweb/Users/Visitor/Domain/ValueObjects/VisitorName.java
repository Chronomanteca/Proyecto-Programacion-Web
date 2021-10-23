package com.example.proyectoprogramacionweb.Users.Visitor.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.StringValueObject;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.Exceptions.InvalidVisitorName;

import java.util.regex.Pattern;

public class VisitorName extends StringValueObject {
    private VisitorName() {}
    public VisitorName(String name){
        validate(name);
        this.value = name;
    }

    private void validate(String name) {
        nameFormat(name);
    }

    private void nameFormat(String name){
        int length = name.length();
        if(length>45){
            throw new InvalidVisitorName("El nombre ingresado no es validom, debe tener 45 o menos caracteres");
        }
    }

}
