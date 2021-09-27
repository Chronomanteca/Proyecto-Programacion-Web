package com.example.proyectoprogramacionweb.Estates.Application.Find;

import com.example.proyectoprogramacionweb.Estates.Domain.Estate;
import com.example.proyectoprogramacionweb.Estates.Domain.Exceptions.EstateNotFoundByCity;
import com.example.proyectoprogramacionweb.Estates.Domain.Ports.EstateRepository;
import com.example.proyectoprogramacionweb.Estates.Domain.ValueObjects.EstateCity;

import java.util.List;
import java.util.Optional;

public class EstateCityFinder {
    private EstateRepository repository;

    public EstateCityFinder(EstateRepository repository) {
        this.repository = repository;
    }
    public List<Estate> execute(String city){
        Optional<List<Estate>> estates = repository.findByCity(new EstateCity(city));
        if(estates.isEmpty())
            throw new EstateNotFoundByCity("No hay inmuebles en la ciudad encontrada");
        return estates.get();
    }
}
