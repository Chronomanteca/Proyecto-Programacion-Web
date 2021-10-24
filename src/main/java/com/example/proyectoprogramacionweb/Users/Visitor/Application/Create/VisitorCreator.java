package com.example.proyectoprogramacionweb.Users.Visitor.Application.Create;

import com.example.proyectoprogramacionweb.Shared.Domain.Ids.VisitorId;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.Ports.VisitorRepository;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.ValueObjects.*;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.Visitor;

public class VisitorCreator {
    private VisitorRepository repository;

    public VisitorCreator(VisitorRepository repository) {
        this.repository = repository;
    }

    public void execute(String visitorId, String name, Integer age, Integer phoneNumber, String email, String password){
        Visitor visitor = Visitor.Create(new VisitorId(visitorId), new VisitorName(name), new VisitorAge(age),
                new VisitorPhoneNumber(phoneNumber), new VisitorEmail(email), new VisitorPassword(password));
        repository.save(visitor);
    }
}
