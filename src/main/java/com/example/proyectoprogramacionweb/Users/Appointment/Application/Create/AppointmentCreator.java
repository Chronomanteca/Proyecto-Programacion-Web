package com.example.proyectoprogramacionweb.Users.Appointment.Application.Create;

import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EstateId;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.VisitorId;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.Appointment;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.Ports.AppointmentDateValidator;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.Ports.AppointmentRepository;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.Services.DomainAppointmentDateValidator;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.ValueObjects.AppointmentDate;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.ValueObjects.AppointmentState;

public class AppointmentCreator {
    private AppointmentRepository repository;
    //private DomainAppointmentDateValidator validator;

    public AppointmentCreator(AppointmentRepository repository) {
        this.repository = repository;
    }

    public void execute(String estateId, String visitorId, String date, String state){
        //Validar la fecha de la cita
        Appointment appointment = Appointment.Create(new EstateId(estateId),
                new VisitorId(visitorId), new AppointmentDate(date), new AppointmentState(state));
        repository.save(appointment);
    }
}
