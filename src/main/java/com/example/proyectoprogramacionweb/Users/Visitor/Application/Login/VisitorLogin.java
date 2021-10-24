package com.example.proyectoprogramacionweb.Users.Visitor.Application.Login;


import com.example.proyectoprogramacionweb.Shared.Application.TokenGeneration;
import com.example.proyectoprogramacionweb.Shared.Application.TokenGenerationResponse;
import com.example.proyectoprogramacionweb.Shared.Domain.Exceptions.PasswordNotValid;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.Exceptions.VisitorNotFound;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.Ports.VisitorRepository;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.ValueObjects.VisitorEmail;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.ValueObjects.VisitorPassword;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.Visitor;
import com.example.proyectoprogramacionweb.Users.Visitor.Infrastructure.Hibernate.HibernateVisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VisitorLogin {

    @Autowired
    HibernateVisitorRepository repo;

    private final TokenGeneration tokenGeneration;

    public TokenGeneration getTokenGeneration() {
        return tokenGeneration;
    }

    public VisitorLogin(TokenGeneration tokenGeneration) {
        this.tokenGeneration = tokenGeneration;
    }

    public VisitorLoginResponse execute(String mail, String password){
        Optional<List<Visitor>> visitors = findAll();
        Optional<Visitor> visitor = visitorExists(mail,password,visitors);
        TokenGenerationResponse responseToken = this.tokenGeneration.execute(mail);
        VisitorLoginResponse response = new VisitorLoginResponse(mail, responseToken.token());
        return response;
        }


    private Optional<Visitor> visitorExists(String mail,String password,Optional<List<Visitor>> visitors){
        ArrayList<Visitor> visitor = new ArrayList<>();
        if(visitors!=null){
            visitors.get().forEach(v -> {
                if(v != null){
                    VisitorEmail test = (VisitorEmail) v.data().get("visitorEmail");
                    if(v.data().get("visitorEmail").equals(new VisitorEmail(mail))){
                        if(!visitorPasswordCheck(password,v)){
                            throw new PasswordNotValid("La contraseña enviada no corresponde con la del mail ingresado"+" "+test.value()+"\n inputed email:"+mail+ " inputed password "+password);
                        }
                        else{
                            visitor.add(v);
                        }
                    }
                }

            });
        }
        else{
            throw new VisitorNotFound("El mail del visitante ingresado no se encontro en la base de datos");
        }
        return Optional.of(visitor.get(0));
    }

    private boolean visitorPasswordCheck(String password, Visitor visitor){
        if(((VisitorPassword)visitor.data().get("visitorPassword")).value().compareTo(password)==0){
            return true;
        }
        return false;
    }


    private Optional<List<Visitor>> findAll(){
        Optional<List<Visitor>> allVisitors = repo.findAll();
        ArrayList<Visitor> visitor = new ArrayList<>();

        if(allVisitors.isPresent()){
            allVisitors.get().forEach(v -> {
                      visitor.add(v);
            });
        }
        if(allVisitors.isEmpty()){
            return null;
        }

        return Optional.of(visitor);

    }




}
