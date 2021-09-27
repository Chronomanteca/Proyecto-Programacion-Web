package com.example.proyectoprogramacionweb.Estates.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.StringValueObject;

public class EstateAddress extends StringValueObject {
    private EstateAddress(){}
    public EstateAddress(String address){
        validate(address);
        this.value = address;
    }

    private void validate(String address) {
        //TODO: Validacion de la direccion del inmueble
    }
}
