package com.example.proyectoprogramacionweb.Estates.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.StringValueObject;

public class EstateCity extends StringValueObject {
    private EstateCity(){}
    public EstateCity(String city){
        validate(city);
        this.value = city;
    }

    private void validate(String city) {
        //TODO: Validacion de la ciudad del inmueble
    }
}
