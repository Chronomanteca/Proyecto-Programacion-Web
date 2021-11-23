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

    public void execute(String id, String appoinmenDate, String visitorId){
        Estate e = finder.execute(id);
        EstateAppointment appointment = new EstateAppointment(appoinmenDate,visitorId);
        e.addAppointment(appointment);
        System.out.println("Termina");
        repository.save(e);
    }
}
