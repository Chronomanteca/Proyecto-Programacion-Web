package com.example.proyectoprogramacionweb.Users.Appointment.Application;

import com.example.proyectoprogramacionweb.Shared.Domain.Bus.Event.EventBus;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EstateId;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.VisitorId;
import com.example.proyectoprogramacionweb.Users.Appointment.Application.Create.AppointmentCreator;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.Appointment;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.Exceptions.InvalidAppointmentDate;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.Exceptions.InvalidAppointmentState;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.Ports.AppointmentRepository;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.ValueObjects.AppointmentDate;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.ValueObjects.AppointmentState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.format.DateTimeParseException;

@SpringBootTest
public class AppointmentCreatorTest {

    AppointmentRepository repository;
    EventBus bus;
    Appointment appointment;

    @BeforeEach
    void setup(){
        this.appointment = new Appointment(new EstateId("83d02a58-9326-4f63-aea0-8452f85a15bb"),
                new VisitorId("068cc956-bc95-44ef-8f17-e4ae35a3e44d"), new AppointmentDate("12/12/2021 09:00"),
                new AppointmentState("confirmed"));
        this.repository = Mockito.mock(AppointmentRepository.class);
        this.bus = Mockito.mock(EventBus.class);
    }

    @Test
    void create_appointment(){
        AppointmentCreator creator = new AppointmentCreator(repository,bus);
        creator.execute("83d02a58-9326-4f63-aea0-8452f85a15bb",
                "068cc956-bc95-44ef-8f17-e4ae35a3e44d","12/12/2021 09:00","confirmed");
        Mockito.verify(repository,Mockito.atLeastOnce()).save(appointment);
    }

    @Test
    void should_not_create_appointment_invalid_date_parse(){
        AppointmentCreator creator = new AppointmentCreator(repository,bus);
        Assertions.assertThrows(InvalidAppointmentDate.class, ()->{
            creator.execute("83d02a58-9326-4f63-aea0-8452f85a15bb",
                    "068cc956-bc95-44ef-8f17-e4ae35a3e44d","12/13/2021 09:00","confirmed");
        });
    }

    @Test
    void should_not_create_appointment_invalid_date_today(){
        AppointmentCreator creator = new AppointmentCreator(repository,bus);
        Assertions.assertThrows(InvalidAppointmentDate.class, ()->{
            creator.execute("83d02a58-9326-4f63-aea0-8452f85a15bb",
                    "068cc956-bc95-44ef-8f17-e4ae35a3e44d","12/12/2020 09:00","confirmed");
        });
    }
    @Test
    void should_not_create_appointment_invalid_state(){
        AppointmentCreator creator = new AppointmentCreator(repository,bus);
        Assertions.assertThrows(InvalidAppointmentState.class, ()->{
            creator.execute("83d02a58-9326-4f63-aea0-8452f85a15bb",
                    "068cc956-bc95-44ef-8f17-e4ae35a3e44d","12/12/2021 09:00","mal");
        });
    }
}
