package com.example.proyectoprogramacionweb.Estates.Estate.Application.Find;

import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Estate;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Exceptions.EstateNotFoundByCity;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Ports.EstateRepository;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.ValueObjects.EstateCity;

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
