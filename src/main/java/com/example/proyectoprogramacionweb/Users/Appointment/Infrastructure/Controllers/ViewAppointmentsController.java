package com.example.proyectoprogramacionweb.Users.Appointment.Infrastructure.Controllers;

import com.example.proyectoprogramacionweb.Estates.Domain.Estate;
import com.example.proyectoprogramacionweb.Estates.Infrastructure.Hibernate.HibernateEstateRepository;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EnterpriseId;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EstateId;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.VisitorId;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.Appointment;
import com.example.proyectoprogramacionweb.Users.Appointment.Infrastructure.Hibernate.HibernateAppointmentRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadPoolExecutor;

@RestController
public class ViewAppointmentsController {

    @Autowired
    private HibernateAppointmentRepository repo;

    @Operation(summary = "Gets the selected estate data to be shown in the Frontend", tags = {"Estate", "View"})
    @GetMapping(value = "/visitors/{visitorId}/appointments")
    public @ResponseBody ResponseEntity<List<Appointment>> getVisitorAppointments(@PathVariable String visitorId) {

        Optional<List<Appointment>> appointments = findAllById(new VisitorId(visitorId));

        if(appointments.isPresent()){
            return new ResponseEntity<>(appointments.get(), HttpStatus.FOUND);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @Operation(summary = "Gets the selected estate data to be shown in the Frontend", tags = {"Estate", "View"})
    @GetMapping(value = "/enterprises/{enterpriseId}/appointments")
    public @ResponseBody ResponseEntity<List<Appointment>> getEnterpriseAppointments(@PathVariable String enterpriseId) {

        Optional<List<Appointment>> appointments = findAllById(new EnterpriseId(enterpriseId));

        if(appointments.isPresent()){
            return new ResponseEntity<>(appointments.get(), HttpStatus.FOUND);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    public Optional<List<Appointment>> findAllById(VisitorId id){
        Optional<List<Appointment>> allAppointments = repo.findAll();
        ArrayList<Appointment> appointments = new ArrayList<>();

        if(allAppointments.isPresent()){
            allAppointments.get().forEach(a -> {
                if(((String)a.data().get("visitorId")).compareTo(id.value()) == 0){
                    appointments.add(a);
                }
            });
        }

        if(appointments.isEmpty()){
            return null;
        }

        return Optional.of(appointments);
    }

    public Optional<List<Appointment>> findAllById(EnterpriseId id){
        Optional<List<Appointment>> allAppointments = repo.findAll();
        ArrayList<Appointment> appointments = new ArrayList<>();

        if(allAppointments.isPresent()){
            allAppointments.get().forEach(a -> {
                if(((String)a.data().get("enterpriseId")).compareTo(id.value()) == 0){
                    appointments.add(a);
                }
            });
        }

        if(appointments.isEmpty()){
            return null;
        }

        return Optional.of(appointments);
    }
}
