package com.example.proyectoprogramacionweb.Estates.Application.Update;

import com.example.proyectoprogramacionweb.Estates.Domain.Estate;
import com.example.proyectoprogramacionweb.Estates.Domain.Ports.EstateRepository;
import com.example.proyectoprogramacionweb.Estates.Domain.Services.DomainEstateFinder;
import com.example.proyectoprogramacionweb.Estates.Domain.ValueObjects.EstateAction;

public class EstateActionUpdater {

    private EstateRepository repository;
    private DomainEstateFinder finder;

    public EstateActionUpdater(EstateRepository repository, DomainEstateFinder finder) {
        this.repository = repository;
        this.finder = finder;
    }

    public void execute(String id, String action){
        Estate estate = finder.execute(id);
        estate.updateAction(new EstateAction(action));
        repository.save(estate);
    }
}
