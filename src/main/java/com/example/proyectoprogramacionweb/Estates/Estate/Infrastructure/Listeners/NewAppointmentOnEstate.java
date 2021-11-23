package com.example.proyectoprogramacionweb.Estates.Estate.Infrastructure.Listeners;

import com.example.proyectoprogramacionweb.Estates.Estate.Application.Create.CreateAppointment;
import com.example.proyectoprogramacionweb.Shared.Domain.DomainEvents.CreateAppointmentDomainEvent;
import org.springframework.context.event.EventListener;

public final class NewAppointmentOnEstate {
    private CreateAppointment createAppointment;

    public NewAppointmentOnEstate(CreateAppointment createAppointment){
        this.createAppointment = createAppointment;
    }

    @EventListener
    public void on(CreateAppointmentDomainEvent event){
        this.createAppointment.execute(event.aggregateId(),event.getAppointmentDate(),event.getIdVisitor());
    }

}
