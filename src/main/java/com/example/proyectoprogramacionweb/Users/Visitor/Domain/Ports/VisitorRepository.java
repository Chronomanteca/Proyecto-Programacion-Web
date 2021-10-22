package com.example.proyectoprogramacionweb.Users.Visitor.Domain.Ports;

import com.example.proyectoprogramacionweb.Shared.Domain.Ids.VisitorId;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.Visitor;

import java.util.Optional;

public interface VisitorRepository {
    void save(Visitor visitor);
    Optional<Visitor> find(VisitorId id);
}
