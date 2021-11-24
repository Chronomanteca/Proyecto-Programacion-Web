package com.example.proyectoprogramacionweb.Users.Enterprise.Application.NotifyNewAppointment;

import com.example.proyectoprogramacionweb.Estates.Estate.Application.Find.EstateFinder;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Estate;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Ports.EstateRepository;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Services.DomainEstateFinder;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EnterpriseId;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.Enterprise;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.Exceptions.EnterpriseNotFound;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.Ports.EnterpriseRepository;
import com.example.proyectoprogramacionweb.Users.Enterprise.Infrastructure.Hibernate.HibernateEnterpriseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NotifyNewAppointment {

    private EnterpriseRepository repository;
    private EstateFinder estateFinder;

    public NotifyNewAppointment(EnterpriseRepository repository, EstateFinder estateFinder) {
        this.repository = repository;
        this.estateFinder = estateFinder;
    }

    public void execute(String estateId, String idVisitor, String appointmentDate){
        Estate estate = estateFinder.execute(estateId);
        String idEnterprise = (String) estate.data().get("estateEnterpriseId");
        Optional<List<Enterprise>> enterprises = findAll();
        Optional<Enterprise> enterprise = enterpriseExists(idEnterprise, enterprises);
        Enterprise realEnterprise = enterprise.get();

        realEnterprise.notifyNewAppointment(idVisitor);
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
