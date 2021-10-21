package com.example.proyectoprogramacionweb.Users.Appointment.Infrastructure.Hibernate;

import com.example.proyectoprogramacionweb.Shared.Infrastructure.Hibernate.HibernateRepository;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.Appointment;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.Ports.AppointmentRepository;
import com.example.proyectoprogramacionweb.Users.Appointment.Domain.ValueObjects.AppointmentDate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class HibernateAppointmentRepository extends HibernateRepository<Appointment> implements AppointmentRepository {

    public HibernateAppointmentRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Appointment.class);
    }

    @Override
    public void save(Appointment appointment) {
        persist(appointment);
    }

    @Override
    public void update(Appointment appointment) {
        updateEntity(appointment);
    }

    @Override
    public void delete(Appointment appointment) {
        deleteEntity(appointment);
    }

    @Override
    public Optional<List<Appointment>> findAll() {
        return getAll();
    }
}
