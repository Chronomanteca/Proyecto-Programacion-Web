package com.example.proyectoprogramacionweb.Users.Appointment.Domain.Services;

import com.example.proyectoprogramacionweb.Users.Appointment.Domain.Exceptions.InvalidAppointmentDate;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.Ports.AppointmentDateValidator;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.ValueObjects.AppointmentDate;

public class DomainAppointmentDateValidator {
    private AppointmentDateValidator validator;

    public DomainAppointmentDateValidator(AppointmentDateValidator validator) {
        this.validator = validator;
    }
    public AppointmentDate execute(String date){
        AppointmentDate  appointmentDate = new AppointmentDate(date);
        if(!validator.validateDate(appointmentDate))
            throw new InvalidAppointmentDate("La fecha de la cita está ocupada");
        return appointmentDate;
    }
}
