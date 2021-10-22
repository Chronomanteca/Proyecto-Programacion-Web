package com.example.proyectoprogramacionweb.Users.Appointment.Infrastructure.Controllers;

import com.example.proyectoprogramacionweb.Estates.Domain.Estate;
import com.example.proyectoprogramacionweb.Estates.Infrastructure.Hibernate.HibernateEstateRepository;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EnterpriseId;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EstateId;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.VisitorId;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.Appointment;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.ValueObjects.AppointmentDate;
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

    @Autowired
    private HibernateEstateRepository repoEstate;

    @Operation(summary = "Gets all the appointments of a visitor", tags = {"Appointment", "View"})
    @GetMapping(value = "/visitors/{visitorId}/appointments")
    public @ResponseBody ResponseEntity<List<AppointmentRequest>> getVisitorAppointments(@PathVariable String visitorId) {
        Optional<List<Appointment>> appointments = findAllById(new VisitorId(visitorId));
        ArrayList<AppointmentRequest> appointmentsRequest = new ArrayList<>();
        return fillAppointmentsRequest(appointments);
    }

    @Operation(summary = "Gets all the appointments of an enterprise", tags = {"Appointment", "View"})
    @GetMapping(value = "/enterprises/{enterpriseId}/appointments")
    public @ResponseBody ResponseEntity<List<AppointmentRequest>> getEnterpriseAppointments(@PathVariable String enterpriseId) {
        Optional<List<Appointment>> appointments = findAllById(new EnterpriseId(enterpriseId));
        ArrayList<AppointmentRequest> appointmentsRequest = new ArrayList<>();
        return fillAppointmentsRequest(appointments);
    }

    public ResponseEntity<List<AppointmentRequest>> fillAppointmentsRequest(Optional<List<Appointment>> appointments){
        ArrayList<AppointmentRequest> appointmentsRequest = new ArrayList<>();

        if(appointments.isPresent()){
            appointments.get().forEach(a -> {
                appointmentsRequest.add(new AppointmentRequest((String)a.data().get("estateId"),
                        (String)a.data().get("visitorId"),
                        (String)a.data().get("appointmentDate")));
            });

            return new ResponseEntity<>(appointmentsRequest, HttpStatus.OK);
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
        Optional<List<Estate>> allEstates = repoEstate.findAll();
        ArrayList<Appointment> appointments = new ArrayList<>();

        if(allAppointments.isPresent()){
            allAppointments.get().forEach(a -> {
                allEstates.get().forEach(e -> {
                    if(((String)a.data().get("estateId")).compareTo((String)e.data().get("estateId")) == 0){
                        if(((String)e.data().get("estateEnterpriseId")).compareTo(id.value()) == 0){
                            appointments.add(a);
                        }
                    }
                });
            });
        }

        if(appointments.isEmpty()){
            return null;
        }

        return Optional.of(appointments);
    }

    public static class AppointmentRequest{
        private String estateId;
        private String visitorId;
        private String appointmentDate;

        public AppointmentRequest() {
        }

        public AppointmentRequest(String estateId, String visitorId, String appointmentDate) {
            this.estateId = estateId;
            this.visitorId = visitorId;
            this.appointmentDate = appointmentDate;
        }

        public String getEstateId() {
            return estateId;
        }

        public void setEstateId(String estateId) {
            this.estateId = estateId;
        }

        public String getVisitorId() {
            return visitorId;
        }

        public void setVisitorId(String visitorId) {
            this.visitorId = visitorId;
        }

        public String getAppointmentDate() {
            return appointmentDate;
        }

        public void setAppointmentDate(String appointmentDate) {
            this.appointmentDate = appointmentDate;
        }
    }
}
