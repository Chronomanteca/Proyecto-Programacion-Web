package com.example.proyectoprogramacionweb.Users.Appointment.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.StringValueObject;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.Exceptions.InvalidAppointmentState;

public class AppointmentState extends StringValueObject {
    private AppointmentState(){}

    public AppointmentState(String state) {
        validate(state);
        this.value = state;
    }

    private void validate(String state) {
        if(!state.equals("pending") && !state.equals("confirmed"))
            throw new InvalidAppointmentState("El estado de la cita solo puede ser 'pending' o 'confirmed'");
    }
}
