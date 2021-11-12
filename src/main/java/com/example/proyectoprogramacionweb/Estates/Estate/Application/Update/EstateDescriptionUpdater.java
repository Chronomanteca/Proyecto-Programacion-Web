package com.example.proyectoprogramacionweb.Estates.Estate.Application.Update;

import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Estate;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Ports.EstateRepository;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Services.DomainEstateFinder;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.ValueObjects.EstateDescription;

public class EstateDescriptionUpdater {

    private EstateRepository repository;
    private DomainEstateFinder finder;

    public EstateDescriptionUpdater(EstateRepository repository, DomainEstateFinder finder) {
        this.repository = repository;
        this.finder = finder;
    }

    public void execute(String id, String description){
        Estate estate = finder.execute(id);
        estate.updateDescription(new EstateDescription(description));
        repository.save(estate);
    }
}
