package com.example.proyectoprogramacionweb.Users.Appointment.Domain;

import com.example.proyectoprogramacionweb.Shared.Domain.DomainEvents.CreateAppointmentDomainEvent;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EstateId;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.VisitorId;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.ValueObjects.AppointmentDate;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.ValueObjects.AppointmentState;
import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.AggregateRoot;

import java.util.HashMap;
import java.util.Objects;

public class Appointment extends AggregateRoot{
    private EstateId estateId;
    private VisitorId visitorId;
    private AppointmentDate appointmentDate;
    private AppointmentState state;

    private Appointment() {
    }

    public Appointment(EstateId estateId, VisitorId visitorId, AppointmentDate appointmentDate, AppointmentState state) {
        this.estateId = estateId;
        this.visitorId = visitorId;
        this.appointmentDate = appointmentDate;
        this.state = state;
    }

    public static Appointment Create(EstateId estateId, VisitorId visitorId, AppointmentDate appointmentDate, AppointmentState state){
        return new Appointment(estateId,visitorId,appointmentDate,state);
    }

    public void createAppointmentEvent(){
        this.record(new CreateAppointmentDomainEvent(this.estateId.value(),this.visitorId.value()));
    }

    public HashMap<String,Object> data(){
        return new HashMap<String,Object>(){{
            put("estateId",estateId);
            put("visitorId",visitorId);
            put("appointmentDate",appointmentDate);
            put("state",state);
        }};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(estateId, that.estateId) && Objects.equals(visitorId, that.visitorId) && Objects.equals(appointmentDate, that.appointmentDate) && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estateId, visitorId, appointmentDate, state);
    }
}
