package com.example.proyectoprogramacionweb.Estates.Estate.Application.Create;

import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Estate;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Exceptions.EstateAlreadyExists;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Ports.EstateRepository;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.ValueObjects.*;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EnterpriseId;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EstateId;

import java.util.Optional;

public class EstateCreator {
    private EstateRepository repository;

    public EstateCreator(EstateRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, Double price, String type, String action, Integer roomsNumber,
                        Integer bathroomNumber, Double area, String city, String address, String description,
                        String enterpriseId){
        validate(id);
        Estate estate = Estate.Create(new EstateId(id),new EstatePrice(price), new EstateType(type),
                new EstateAction(action), new EstateRoomsNumber(roomsNumber), new EstateBathroomNumber(bathroomNumber),
                new EstateArea(area), new EstateCity(city), new EstateAddress(address), new EstateDescription(description),
                new EnterpriseId(enterpriseId));
        repository.save(estate);
    }

    private void validate(String id) {
        Optional<Estate> estate = repository.find(new EstateId(id));
        if(estate.isPresent())
            throw new EstateAlreadyExists("The estate with id " + id + " already exists");
    }
}
