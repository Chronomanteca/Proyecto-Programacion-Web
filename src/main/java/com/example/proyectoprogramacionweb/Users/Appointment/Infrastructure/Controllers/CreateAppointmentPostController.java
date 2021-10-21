package com.example.proyectoprogramacionweb.Users.Appointment.Infrastructure.Controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name="Appointment", description = "The Appointment API")
@RequestMapping(value = "/enterprise/{enterpriseId}/properties/{property}")
public class CreateAppointmentPostController {


}
