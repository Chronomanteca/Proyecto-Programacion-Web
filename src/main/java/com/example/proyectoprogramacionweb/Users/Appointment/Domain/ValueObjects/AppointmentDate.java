package com.example.proyectoprogramacionweb.Users.Appointment.Domain.ValueObjects;

import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.StringValueObject;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.Exceptions.InvalidAppointmentDate;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import org.apache.tomcat.jni.Local;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class AppointmentDate extends StringValueObject {
    private AppointmentDate(){}
    public AppointmentDate(String date){
        validate(date);
        this.value = date;
    }

    private void validate(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime test = LocalDateTime.parse(date,dtf);
        if(test.isBefore(now)){
            throw new InvalidAppointmentDate("No se puede crear una cita antes de la fecha actual\nFecha de hoy: "+dtf.format(now)+" Fecha ingresada "+dtf.format(test));
        }


        }





    private void CurrentDate(String date){

    }
}
