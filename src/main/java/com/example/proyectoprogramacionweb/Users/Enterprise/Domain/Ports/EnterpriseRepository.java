package com.example.proyectoprogramacionweb.Users.Enterprise.Domain.Ports;

import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EnterpriseId;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.Enterprise;

public interface EnterpriseRepository {
    void save(Enterprise enterprise);
    Enterprise find (EnterpriseId id);
}
