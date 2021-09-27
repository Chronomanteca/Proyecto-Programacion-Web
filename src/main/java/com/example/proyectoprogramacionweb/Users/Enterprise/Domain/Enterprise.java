package com.example.proyectoprogramacionweb.Users.Enterprise.Domain;

import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EnterpriseId;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.ValueObjects.EnterpriseName;

import java.util.HashMap;
import java.util.Objects;

public class Enterprise {
    private EnterpriseId enterpriseId;
    private EnterpriseName name;

    public Enterprise(EnterpriseId enterpriseId, EnterpriseName enterpriseName) {
        this.enterpriseId = enterpriseId;
        this.name = enterpriseName;
    }
    public static Enterprise Create(EnterpriseId enterpriseId, EnterpriseName enterpriseName){
        return new Enterprise(enterpriseId,enterpriseName);
    }
    public HashMap<String, Object> data(){
        return new HashMap<String,Object>(){{
           put("enterpriseId",enterpriseId);
           put("enterpriseName", name);
        }};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enterprise that = (Enterprise) o;
        return Objects.equals(enterpriseId, that.enterpriseId) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enterpriseId, name);
    }
}
