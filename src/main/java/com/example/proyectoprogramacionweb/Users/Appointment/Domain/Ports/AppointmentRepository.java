package com.example.proyectoprogramacionweb.Users.Appointment.Domain.Ports;

import com.example.proyectoprogramacionweb.Users.Appointment.Domain.Appointment;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.ValueObjects.AppointmentDate;

public interface AppointmentRepository {
    void save(Appointment appointment);
    Boolean validateDate(AppointmentDate date);
}