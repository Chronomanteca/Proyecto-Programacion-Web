package com.example.proyectoprogramacionweb.Users.Enterprise.Application.Create;

import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EnterpriseId;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.Enterprise;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.Ports.EnterpriseRepository;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.ValueObjects.EnterpriseName;

public class EnterpriseCreator {
    private EnterpriseRepository repository;

    public EnterpriseCreator(EnterpriseRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, String name){
        Enterprise enterprise = Enterprise.Create(new EnterpriseId(id),new EnterpriseName(name));
        repository.save(enterprise);
    }
}
