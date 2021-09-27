package com.example.proyectoprogramacionweb.Users.Appointment.Domain.Exceptions;

public class InvalidAppointmentDate extends RuntimeException {
    public InvalidAppointmentDate(String message) {
        super(message);
    }
}
