package com.example.proyectoprogramacionweb.Estates.Estate.Application.Delete;

import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Estate;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Exceptions.EstateNotFound;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Ports.EstateRepository;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Services.DomainEstateFinder;

public class EstateDeleter {
    private EstateRepository repository;
    private DomainEstateFinder finder;

    public EstateDeleter(EstateRepository repository, DomainEstateFinder finder) {
        this.repository = repository;
        this.finder = finder;
    }

    public void execute(String estateId){
        //Find the estate
        Estate estate = finder.execute(estateId);
        if(estate == null)
            throw new EstateNotFound("We didn't find an Estate with the Id " + estateId);
        //Delete estate
        repository.delete(estate);
    }
}
