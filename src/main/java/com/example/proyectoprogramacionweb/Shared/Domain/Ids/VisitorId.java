package com.example.proyectoprogramacionweb.Shared.Domain.Ids;

import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.CustomUUID;

public class VisitorId extends CustomUUID {

    private VisitorId(){}

    public VisitorId(String value) {
        super(value);
    }
}
