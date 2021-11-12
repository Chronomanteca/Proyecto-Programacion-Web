package com.example.proyectoprogramacionweb.Estates.Estate.Domain.Services;

import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Estate;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Exceptions.EstateNotFound;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Ports.EstateRepository;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EstateId;

import java.util.Optional;

public class DomainEstateFinder {
    private EstateRepository repository;

    public DomainEstateFinder(EstateRepository repository) {
        this.repository = repository;
    }
    public Estate execute(String id){
        Optional<Estate> estateOptional = repository.find(new EstateId(id));
        if(estateOptional.isEmpty())
            throw new EstateNotFound("El inmueble con id " + id + " no se encontró");
        return estateOptional.get();
    }
}
