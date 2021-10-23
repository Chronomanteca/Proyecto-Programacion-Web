package com.example.proyectoprogramacionweb.Users.Appointment.Domain.Services;

import com.example.proyectoprogramacionweb.Users.Appointment.Domain.Appointment;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.Ports.AppointmentRepository;

public class DomainAppointmentFinder {
    private AppointmentRepository repository;

    public DomainAppointmentFinder(AppointmentRepository repository) {
        this.repository = repository;
    }
    /*TODO: Hay que implementar una forma de buscar una cita en específico
    public Appointment find(String estateId, String visitorId){

    }
     */
}
