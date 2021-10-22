package com.example.proyectoprogramacionweb.Users.Appointment.Domain;

import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EstateId;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.VisitorId;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.ValueObjects.AppointmentDate;

import java.util.HashMap;
import java.util.Objects;

public class Appointment {
    private EstateId estateId;
    private VisitorId visitorId;
    private AppointmentDate appointmentDate;

    private Appointment() {
    }

    public Appointment(EstateId estateId, VisitorId visitorId, AppointmentDate appointmentDate) {
        this.estateId = estateId;
        this.visitorId = visitorId;
        this.appointmentDate = appointmentDate;
    }
    public static Appointment Create(EstateId estateId, VisitorId visitorId, AppointmentDate appointmentDate){
        return new Appointment(estateId,visitorId,appointmentDate);
    }
    public HashMap<String,Object> data(){
        return new HashMap<String,Object>(){{
            put("estateId",estateId.value());
            put("visitorId",visitorId.value());
            put("appointmentDate",appointmentDate.value());
        }};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(estateId, that.estateId) && Objects.equals(visitorId, that.visitorId) && Objects.equals(appointmentDate, that.appointmentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estateId, visitorId, appointmentDate);
    }
}
