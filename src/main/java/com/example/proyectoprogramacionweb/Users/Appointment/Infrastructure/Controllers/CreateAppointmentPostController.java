package com.example.proyectoprogramacionweb.Users.Appointment.Infrastructure.Controllers;

import com.example.proyectoprogramacionweb.Users.Appointment.Application.Create.AppointmentCreator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name="Appointment", description = "The Appointment API")
@RequestMapping(value = "/enterprise/{enterpriseId}/appointments")
public class CreateAppointmentPostController {

    @Autowired
    private AppointmentCreator creator;

    @Operation(summary = "Create a new Appointment", description = "Create new Appointment", tags = {"Appointment"})
    @PostMapping(value = "/appointment")
    public ResponseEntity execute(@RequestBody AppointmentRequest request){
        System.out.println(request.toString());
        this.creator.execute(request.getEstateId(),request.getVisitorId(),request.getAppointmentDate()
                ,request.getState());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    static class AppointmentRequest{
        private String estateId;
        private String visitorId;
        private String appointmentDate;
        private String state;

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

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public AppointmentRequest() {
        }
    }
}
