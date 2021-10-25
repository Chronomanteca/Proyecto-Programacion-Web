package com.example.proyectoprogramacionweb.Shared.Domain.Bus.Event.RabbitMQ;

import com.example.proyectoprogramacionweb.Shared.Domain.Bus.Event.DomainEvent;
import com.example.proyectoprogramacionweb.Shared.Domain.DomainEvents.CreateAppointmentDomainEvent;

import java.util.HashMap;

public class DomainEventsInformation {

    private final HashMap<String, Class<? extends DomainEvent>> indexedDomainEvent = new HashMap<>();
    private final HashMap<String, String> domainEventSubscribers = new HashMap<>();

    public DomainEventsInformation() {
        indexedDomainEvent.put("appointment.create", CreateAppointmentDomainEvent.class);
        domainEventSubscribers.put("proyectoProgramacionWebApplication.Users.Appointment.appointment.create", "NotifyNewAppointmentOnCreateAppointment");
    }

    public Class<? extends DomainEvent> getDomainEvent(String name) {
        return indexedDomainEvent.get(name);
    }

    public boolean validateEventSubscriber(String name) {
        return domainEventSubscribers.containsKey(name);
    }

    public String getEventSubscriber(String name) {
        return domainEventSubscribers.get(name);
    }

}