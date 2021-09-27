package com.example.proyectoprogramacionweb.Users.Visitor.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.StringValueObject;

public class VisitorEmail extends StringValueObject {
    private VisitorEmail() {}
    public VisitorEmail(String email){
        validate(email);
        this.value = email;
    }

    private void validate(String email) {
        //TODO: Validar el correo del visitante
    }
}
