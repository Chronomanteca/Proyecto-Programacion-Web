package com.example.proyectoprogramacionweb.Users.Enterprise.Infrastructure.Listeners;


import com.example.proyectoprogramacionweb.Shared.Domain.DomainEvents.CreateAppointmentDomainEvent;
import com.example.proyectoprogramacionweb.Users.Enterprise.Application.NotifyNewAppointment.NotifyNewAppointment;
import org.springframework.context.event.EventListener;

public final class NotifyNewAppointmentOnCreateAppointment {
    private NotifyNewAppointment notifyNewAppointment;

    public NotifyNewAppointmentOnCreateAppointment(NotifyNewAppointment notifyNewAppointment) {
        this.notifyNewAppointment = notifyNewAppointment;
    }

    @EventListener
    public void on(CreateAppointmentDomainEvent event) {
        this.notifyNewAppointment.execute(event.aggregateId(), event.getIdVisitor(), event.getAppointmentDate());
    }

}
