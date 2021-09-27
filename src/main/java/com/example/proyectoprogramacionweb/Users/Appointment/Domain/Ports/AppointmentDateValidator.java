package com.example.proyectoprogramacionweb.Users.Appointment.Domain.Ports;

import com.example.proyectoprogramacionweb.Users.Appointment.Domain.ValueObjects.AppointmentDate;

public interface AppointmentDateValidator {
    Boolean validateDate(AppointmentDate date);
}
