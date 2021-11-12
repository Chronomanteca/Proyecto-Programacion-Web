package com.example.proyectoprogramacionweb.Estates.Estate.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Exceptions.InvalidAddress;
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

    private void addressLength(String address){
        int length =  address.length();
        if(length<12||length>45){
            throw new InvalidAddress("La direccion ingresada no tiene la longitud correcta, debe tener entre 12 y 45 caracteres");
        }
    }
}
