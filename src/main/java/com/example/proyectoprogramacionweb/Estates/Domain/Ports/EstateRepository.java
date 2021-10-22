package com.example.proyectoprogramacionweb.Estates.Domain.Ports;

import com.example.proyectoprogramacionweb.Estates.Domain.Estate;
import com.example.proyectoprogramacionweb.Estates.Domain.ValueObjects.EstateCity;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EstateId;

import java.util.List;
import java.util.Optional;

public interface EstateRepository {
    void save(Estate estate);
    Optional<Estate> find(EstateId id);
    Optional<List<Estate>> findAll();
    Optional<List<Estate>> findByCity(EstateCity city);
}
