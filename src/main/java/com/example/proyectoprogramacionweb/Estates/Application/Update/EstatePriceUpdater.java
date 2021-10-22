package com.example.proyectoprogramacionweb.Estates.Application.Update;

import com.example.proyectoprogramacionweb.Estates.Domain.Estate;
import com.example.proyectoprogramacionweb.Estates.Domain.Ports.EstateRepository;
import com.example.proyectoprogramacionweb.Estates.Domain.Services.DomainEstateFinder;
import com.example.proyectoprogramacionweb.Estates.Domain.ValueObjects.EstatePrice;

public class EstatePriceUpdater {

    private DomainEstateFinder finder;
    private EstateRepository repository;

    public EstatePriceUpdater(EstateRepository repository, DomainEstateFinder finder) {
        this.repository = repository;
        this.finder = finder;
    }

    public void execute(String id, Double price){
        Estate estate = finder.execute(id);
        estate.updatePrice(new EstatePrice(price));
        repository.save(estate);
    }
}
