package com.example.proyectoprogramacionweb.Estates.Estate.Domain.Ports;

import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Estate;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.ValueObjects.EstateCity;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EstateId;

import java.util.List;
import java.util.Optional;

public interface EstateRepository {
    void save(Estate estate);
    Optional<Estate> find(EstateId id);
    Optional<List<Estate>> findAll();
    Optional<List<Estate>> findByCity(EstateCity city);
    void delete(Estate estate);
}
