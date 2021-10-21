package com.example.proyectoprogramacionweb.Shared.Domain.Ids;

import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.CustomUUID;

public class EnterpriseId extends CustomUUID {
    private EnterpriseId(){}
    public EnterpriseId(String value) {
        super(value);
    }
}
