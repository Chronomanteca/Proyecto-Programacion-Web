package com.example.proyectoprogramacionweb.Estates.Estate.Application.Create;

import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Entities.EstateAppointment;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Estate;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Ports.EstateRepository;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Services.DomainEstateFinder;

public class CreateAppointment {
    private EstateRepository repository;
    private DomainEstateFinder finder;

    public CreateAppointment(EstateRepository repository, DomainEstateFinder finder) {
        this.repository = repository;
        this.finder = finder;
    }

    public void execute(String id, EstateAppointment appointment){
        Estate e = finder.execute(id);
        e.addAppointment(appointment);
        repository.save(e);
    }
}
