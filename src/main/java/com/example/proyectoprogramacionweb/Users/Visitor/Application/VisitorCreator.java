package com.example.proyectoprogramacionweb.Users.Visitor.Application;

import com.example.proyectoprogramacionweb.Shared.Domain.Ids.VisitorId;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.Ports.VisitorRepository;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.ValueObjects.VisitorAge;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.ValueObjects.VisitorEmail;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.ValueObjects.VisitorName;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.ValueObjects.VisitorPhoneNumber;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.Visitor;

public class VisitorCreator {
    private VisitorRepository repository;

    public VisitorCreator(VisitorRepository repository) {
        this.repository = repository;
    }

    public void execute(String visitorId, String name, Integer age, Integer phoneNumber, String email){
        Visitor visitor = Visitor.Create(new VisitorId(visitorId), new VisitorName(name), new VisitorAge(age),
                new VisitorPhoneNumber(phoneNumber), new VisitorEmail(email));
        repository.save(visitor);
    }
}
