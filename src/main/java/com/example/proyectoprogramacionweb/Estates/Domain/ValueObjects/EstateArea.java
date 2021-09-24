package com.example.proyectoprogramacionweb.Estates.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Estates.Domain.Exceptions.InvalidEstateArea;
import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.DoubleValueObject;

public class EstateArea extends DoubleValueObject {
    private EstateArea(){}
    public EstateArea(Double area){
        validate(area);
        this.value = area;
    }

    private void validate(Double area) {
        if(area.compareTo(0d) <=  0)
            throw new InvalidEstateArea("El area de un inmueble debe ser mayor a cero");
    }
}
