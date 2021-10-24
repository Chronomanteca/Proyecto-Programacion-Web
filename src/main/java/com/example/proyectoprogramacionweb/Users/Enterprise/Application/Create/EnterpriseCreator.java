package com.example.proyectoprogramacionweb.Users.Enterprise.Application.Create;

import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EnterpriseId;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.Enterprise;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.Ports.EnterpriseRepository;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.ValueObjects.EnterpriseEmail;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.ValueObjects.EnterpriseName;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.ValueObjects.EnterprisePassword;

public class EnterpriseCreator {
    private EnterpriseRepository repository;

    public EnterpriseCreator(EnterpriseRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, String name, String email, String password){
        Enterprise enterprise = Enterprise.Create(new EnterpriseId(id),new EnterpriseName(name),new EnterpriseEmail(email), new EnterprisePassword(password));
        repository.save(enterprise);
    }
}
