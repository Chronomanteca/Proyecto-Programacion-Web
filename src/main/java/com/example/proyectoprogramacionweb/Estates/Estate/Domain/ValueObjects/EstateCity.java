package com.example.proyectoprogramacionweb.Estates.Estate.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Exceptions.InvalidEstateCity;
import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.StringValueObject;

import java.util.regex.Pattern;

public class EstateCity extends StringValueObject {
    private EstateCity(){}
    public EstateCity(String city){
        validate(city);
        this.value = city;
    }

    private void validate(String city) {
        CityFormat(city);
    }

    private void CityFormat(String city){
        String regex = "[A-Z][a-z]+";
        if(!Pattern.matches(regex,city)){
            throw new InvalidEstateCity("El formato de la ciudad no es el correcto, debe contener solo letras y empezar en mayuscula");
        }
    }

}
