package com.example.proyectoprogramacionweb.Users.Enterprise.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.StringValueObject;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.Enterprise;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.Exceptions.InvalidEnterpriseName;

public class EnterpriseName extends StringValueObject {
    private EnterpriseName(){}
    public EnterpriseName(String name){
        validate(name);
        this.value = name;
    }

    private void validate(String name) {
        EnterpriseLength(name);
    }

    private void EnterpriseLength(String name){
        int length = name.length();
        if(length > 45){
            throw new InvalidEnterpriseName("El nombre de la empresa debe tener 45 caracteres o menos");
        }
    }



}
