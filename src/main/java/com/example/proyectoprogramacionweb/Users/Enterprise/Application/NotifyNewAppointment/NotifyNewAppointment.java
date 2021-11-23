package com.example.proyectoprogramacionweb.Users.Enterprise.Application.NotifyNewAppointment;

import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EnterpriseId;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.Enterprise;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.Exceptions.EnterpriseNotFound;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.Ports.EnterpriseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NotifyNewAppointment {

    private EnterpriseRepository repository;

    public NotifyNewAppointment(EnterpriseRepository repository) {
        this.repository = repository;
    }

    public void execute(String estateId, String idVisitor){
        Optional<List<Enterprise>> enterprises = findAll();
        Optional<Enterprise> enterprise = enterpriseExists("61b7183b-49c6-481a-9c7b-3227315f8ef0", enterprises);
        Enterprise realEnterprise = enterprise.get();

        realEnterprise.notifyNewAppointment(idVisitor);
        //Optional<Enterprise> optional =repository.find(new EnterpriseId(estateId));
        //if(optional.isPresent()){
        //    Enterprise enterprise = optional.get();
        //    enterprise.notifyNewAppointment(idVisitor);
        //    System.out.println("Si llega");

        //}
    }

    private Optional<Enterprise> enterpriseExists(String idEnterprise, Optional<List<Enterprise>> enterprises) {
        ArrayList<Enterprise> enterprise = new ArrayList<>();
        if(enterprise!=null){
            enterprises.get().forEach(v -> {
                if(v != null){
                    if(v.data().get("enterpriseId").equals(new EnterpriseId(idEnterprise))){
                        enterprise.add(v);
                    }
                }
            });
        }else{
            throw new EnterpriseNotFound("El id de la inmolibilia no se encuentra registrado");
        }
        return Optional.of(enterprise.get(0));
    }

    private Optional<List<Enterprise>> findAll() {
        Optional<List<Enterprise>> allEnterprises = repository.findAll();
        ArrayList<Enterprise> enterprises = new ArrayList<>();

        if(allEnterprises.isPresent()){
            allEnterprises.get().forEach(v -> {
                enterprises.add(v);
            });
        }
        if(allEnterprises.isEmpty()){
            return null;
        }

        return Optional.of(enterprises);
    }
}
