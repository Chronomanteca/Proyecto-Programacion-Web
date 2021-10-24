package com.example.proyectoprogramacionweb.Users.Enterprise.Domain;

import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EnterpriseId;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.ValueObjects.EnterpriseEmail;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.ValueObjects.EnterpriseName;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.ValueObjects.EnterprisePassword;

import java.util.HashMap;
import java.util.Objects;

public class Enterprise {
    private EnterpriseId enterpriseId;
    private EnterpriseName name;
    private EnterpriseEmail enterpriseEmail;
    private EnterprisePassword enterprisePassword;

    public Enterprise (){}

    public Enterprise(EnterpriseId enterpriseId, EnterpriseName enterpriseName, EnterpriseEmail enterpriseEmail, EnterprisePassword enterprisePassword) {
        this.enterpriseId = enterpriseId;
        this.name = enterpriseName;
        this.enterpriseEmail = enterpriseEmail;
        this.enterprisePassword = enterprisePassword;
    }
    public static Enterprise Create(EnterpriseId enterpriseId, EnterpriseName enterpriseName,EnterpriseEmail enterpriseEmail, EnterprisePassword enterprisePassword){
        return new Enterprise(enterpriseId,enterpriseName,enterpriseEmail,enterprisePassword);
    }
    public HashMap<String, Object> data(){
        return new HashMap<String,Object>(){{
           put("enterpriseId",enterpriseId);
           put("enterpriseName", name);
            put("enterpriseEmail", enterpriseEmail);
            put("enterprisePassword", enterprisePassword);
        }};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enterprise that = (Enterprise) o;
        return Objects.equals(enterpriseId, that.enterpriseId) && Objects.equals(name, that.name) && Objects.equals(enterpriseEmail, that.enterpriseEmail) && Objects.equals(enterprisePassword, that.enterprisePassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enterpriseId, name, enterpriseEmail, enterprisePassword);
    }
}
