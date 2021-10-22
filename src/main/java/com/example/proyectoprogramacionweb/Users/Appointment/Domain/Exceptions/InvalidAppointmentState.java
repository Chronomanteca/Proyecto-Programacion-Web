package com.example.proyectoprogramacionweb.Users.Appointment.Domain.Exceptions;

public class InvalidAppointmentState extends RuntimeException {
    public InvalidAppointmentState(String message) {
        super(message);
    }
}
