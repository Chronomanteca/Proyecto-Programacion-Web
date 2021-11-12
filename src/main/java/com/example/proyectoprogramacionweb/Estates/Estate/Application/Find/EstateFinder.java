package com.example.proyectoprogramacionweb.Estates.Estate.Application.Find;

import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Estate;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Ports.EstateRepository;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Services.DomainEstateFinder;

public class EstateFinder {
    private EstateRepository repository;
    private DomainEstateFinder serviceFinder;

    public EstateFinder(EstateRepository repository) {
        this.repository = repository;
        this.serviceFinder = new DomainEstateFinder(repository);
    }
    public Estate execute(String id){
        return serviceFinder.execute(id);
    }
}
