package com.example.proyectoprogramacionweb.Estates.Domain.Entities;

import java.util.HashMap;
import java.util.Objects;

public class EstateAppointment {
    private String appointmenDate;
    private String visitorId;

    public EstateAppointment(String appointmenDate, String visitorId) {
        this.appointmenDate = appointmenDate;
        this.visitorId = visitorId;
    }
    public HashMap<String,Object> data(){
        return new HashMap<>(){{
            put("appointmenDate",appointmenDate);
            put("visitorId",visitorId);
        }};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstateAppointment that = (EstateAppointment) o;
        return Objects.equals(appointmenDate, that.appointmenDate) && Objects.equals(visitorId, that.visitorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmenDate, visitorId);
    }
}
