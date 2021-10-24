package com.example.proyectoprogramacionweb.Users.Enterprise.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.StringValueObject;
import com.example.proyectoprogramacionweb.Shared.Domain.Exceptions.PasswordNotValid;

public class EnterprisePassword extends StringValueObject {

    private EnterprisePassword(){}

    public EnterprisePassword(String password){
        validate(password);
        this.value = password;
    }
    private void validate(String password){
        passwordLength(password);
    }

    private void passwordLength(String password){
        int length = password.length();
        if(length < 6){
            throw new PasswordNotValid("La contraseña debe tener 6 o mas caracteres");
        }
    }
}
