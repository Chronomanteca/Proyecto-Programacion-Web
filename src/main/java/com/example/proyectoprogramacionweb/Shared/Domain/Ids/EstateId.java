package com.example.proyectoprogramacionweb.Shared.Domain.Ids;

import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.CustomUUID;

public class EstateId extends CustomUUID {
    private EstateId(){}
    public EstateId(String value) {
        super(value);
    }
}
