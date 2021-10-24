package com.example.proyectoprogramacionweb.Users.Enterprise.Application.Login;

import com.example.proyectoprogramacionweb.Shared.Application.TokenGeneration;
import com.example.proyectoprogramacionweb.Shared.Application.TokenGenerationResponse;
import com.example.proyectoprogramacionweb.Shared.Domain.Exceptions.PasswordNotValid;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.Enterprise;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.Exceptions.EnterpriseNotFound;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.ValueObjects.EnterpriseEmail;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.ValueObjects.EnterprisePassword;
import com.example.proyectoprogramacionweb.Users.Enterprise.Infrastructure.Hibernate.HibernateEnterpriseRepository;
import com.example.proyectoprogramacionweb.Users.Visitor.Application.Login.VisitorLoginResponse;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.Exceptions.VisitorNotFound;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.ValueObjects.VisitorEmail;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.ValueObjects.VisitorPassword;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.Visitor;
import com.example.proyectoprogramacionweb.Users.Visitor.Infrastructure.Hibernate.HibernateVisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EnterpriseLogin {

    @Autowired
    HibernateEnterpriseRepository repo;

    private final TokenGeneration tokenGeneration;


    public TokenGeneration getTokenGeneration() {
        return tokenGeneration;
    }

    public EnterpriseLogin(TokenGeneration tokenGeneration) {
        this.tokenGeneration = tokenGeneration;
    }

    public EnterpriseLoginResponse execute(String mail, String password){
        Optional<List<Enterprise>> enterprises = findAll();
        Optional<Enterprise> enterprise = enterpriseExists(mail,password,enterprises);
        TokenGenerationResponse responseToken = this.tokenGeneration.execute(mail);
        EnterpriseLoginResponse response = new EnterpriseLoginResponse(mail, responseToken.token());
        return response;
    }


    private Optional<Enterprise> enterpriseExists(String mail,String password,Optional<List<Enterprise>> enterprises){
        ArrayList<Enterprise> enterprise = new ArrayList<>();
        if(enterprises!=null){
            enterprises.get().forEach(v -> {
                if(v != null){
                    if(v.data().get("enterpriseEmail").equals(new EnterpriseEmail(mail))){
                        if(!enterprisePasswordCheck(password,v)){
                            throw new PasswordNotValid("La contraseña enviada no corresponde con la del mail ingresado");
                        }
                        else{
                            enterprise.add(v);
                        }
                    }
                }

            });
        }
        else{
            throw new EnterpriseNotFound("El mail de la inmobiliaria ingresado no se encontro en la base de datos");
        }
        return Optional.of(enterprise.get(0));
    }

    private boolean enterprisePasswordCheck(String password, Enterprise enterprise){
        if(((EnterprisePassword)enterprise.data().get("enterprisePassword")).value().compareTo(password)==0){
            return true;
        }
        return false;
    }


    private Optional<List<Enterprise>> findAll(){
        Optional<List<Enterprise>> allVisitors = repo.findAll();
        ArrayList<Enterprise> enterprises = new ArrayList<>();

        if(allVisitors.isPresent()){
            allVisitors.get().forEach(v -> {
                enterprises.add(v);
            });
        }
        if(allVisitors.isEmpty()){
            return null;
        }

        return Optional.of(enterprises);

    }
}
