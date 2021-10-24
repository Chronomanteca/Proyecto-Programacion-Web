package com.example.proyectoprogramacionweb.Users.Visitor.Domain.Ports;

import com.example.proyectoprogramacionweb.Shared.Domain.Ids.VisitorId;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.Appointment;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.Visitor;

import java.util.List;
import java.util.Optional;

public interface VisitorRepository {
    void save(Visitor visitor);
    Optional<Visitor> find(VisitorId id);
    Optional<List<Visitor>> findAll();
}
