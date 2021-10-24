package com.example.proyectoprogramacionweb.Users.Enterprise.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.StringValueObject;
import com.example.proyectoprogramacionweb.Shared.Domain.Exceptions.EmailNotValid;

import java.util.regex.Pattern;

public class EnterpriseEmail extends StringValueObject {

    private EnterpriseEmail(){}

    public EnterpriseEmail(String email){
        validate(email);
        this.value = email;
    }

    private void validate(String email) {
        emailFormat(email);
    }

    private void emailFormat(String email){
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        if(!Pattern.matches(regex,email)){
            throw new EmailNotValid("El email ingresado no tiene un formato valido");
        }
    }
}
