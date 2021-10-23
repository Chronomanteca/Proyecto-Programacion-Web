package com.example.proyectoprogramacionweb.Users.Appointment.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.StringValueObject;

public class AppointmentDate extends StringValueObject {
    private AppointmentDate(){}
    public AppointmentDate(String date){
        validate(date);
        this.value = date;
    }

    private void validate(String date) {
        //TODO: Validacion de la fecha
    }

    private void CurrentDate(String date){

    }
}
