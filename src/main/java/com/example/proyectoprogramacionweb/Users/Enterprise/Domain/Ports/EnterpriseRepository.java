package com.example.proyectoprogramacionweb.Users.Enterprise.Domain.Ports;

import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EnterpriseId;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.Enterprise;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.Visitor;

import java.util.List;
import java.util.Optional;

public interface EnterpriseRepository {
    void save(Enterprise enterprise);
    Enterprise find (EnterpriseId id);
    Optional<List<Enterprise>> findAll();
}
