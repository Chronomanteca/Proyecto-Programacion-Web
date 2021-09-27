package com.example.proyectoprogramacionweb.Users.Visitor.Domain;

import com.example.proyectoprogramacionweb.Shared.Domain.Ids.VisitorId;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.ValueObjects.VisitorAge;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.ValueObjects.VisitorEmail;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.ValueObjects.VisitorName;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.ValueObjects.VisitorPhoneNumber;

import java.util.HashMap;
import java.util.Objects;

public class Visitor {
    private VisitorId visitorId;
    private VisitorName name;
    private VisitorAge age;
    private VisitorPhoneNumber phoneNumber;
    private VisitorEmail email;

    public Visitor(VisitorId visitorId, VisitorName visitorName, VisitorAge visitorAge,
                   VisitorPhoneNumber visitorPhoneNumber, VisitorEmail visitorEmail) {
        this.visitorId = visitorId;
        this.name = visitorName;
        this.age = visitorAge;
        this.phoneNumber = visitorPhoneNumber;
        this.email = visitorEmail;
    }

    public static Visitor Create(VisitorId visitorId, VisitorName visitorName, VisitorAge visitorAge,
                          VisitorPhoneNumber visitorPhoneNumber, VisitorEmail visitorEmail){
        return new Visitor(visitorId,visitorName,visitorAge,visitorPhoneNumber,visitorEmail);
    }
    public HashMap<String,Object> data(){
        return new HashMap<String,Object>(){{
            put("visitorId",visitorId);
            put("visitorName", name);
            put("visitorAge", age);
            put("visitorPhoneNumber", phoneNumber);
            put("visitorEmail", email);
        }};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visitor visitor = (Visitor) o;
        return Objects.equals(visitorId, visitor.visitorId) && Objects.equals(name, visitor.name) && Objects.equals(age, visitor.age) && Objects.equals(phoneNumber, visitor.phoneNumber) && Objects.equals(email, visitor.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitorId, name, age, phoneNumber, email);
    }
}
