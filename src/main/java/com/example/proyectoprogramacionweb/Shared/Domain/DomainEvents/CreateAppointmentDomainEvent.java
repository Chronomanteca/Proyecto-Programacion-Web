package com.example.proyectoprogramacionweb.Shared.Domain.DomainEvents;

import com.example.proyectoprogramacionweb.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class CreateAppointmentDomainEvent extends DomainEvent {

    private final String visitorId;
    private final String appointmentDate;

    public CreateAppointmentDomainEvent() {
        super(null);
        this.visitorId = "0";
        this.appointmentDate = "01-01-2020 00:00";
    }

    public CreateAppointmentDomainEvent(String aggregateId, String visitorId, String appointmentDate) {
        super(aggregateId);
        this.visitorId = visitorId;
        this.appointmentDate = appointmentDate;

    }

    public CreateAppointmentDomainEvent(String aggregateId, String eventId, String occurrendOn, String visitorId, String appointmentDate) {
        super(aggregateId, eventId, occurrendOn);
        this.visitorId = visitorId;
        this.appointmentDate = appointmentDate;
    }

    public String getIdVisitor() {
        return visitorId;
    }
    public String getAppointmentDate() {
        return appointmentDate;
    }

    @Override
    public String eventName() {
        return "appointment.create";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>() {{
            put("idVisitor", visitorId);
            put("appointmentDate", appointmentDate);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurrendOn) {
        return new CreateAppointmentDomainEvent(aggregateId, eventId, occurrendOn, (String) body.get("idVisitor"), (String) body.get("appointmentDate"));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateAppointmentDomainEvent that = (CreateAppointmentDomainEvent) o;
        return Objects.equals(visitorId, that.visitorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitorId);
    }
}
