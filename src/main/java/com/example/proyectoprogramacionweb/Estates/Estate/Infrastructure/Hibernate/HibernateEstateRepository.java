package com.example.proyectoprogramacionweb.Estates.Estate.Infrastructure.Hibernate;

import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Estate;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Ports.EstateRepository;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.ValueObjects.EstateCity;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EstateId;
import com.example.proyectoprogramacionweb.Shared.Infrastructure.Hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class HibernateEstateRepository extends HibernateRepository<Estate> implements EstateRepository {


    public HibernateEstateRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Estate.class);
    }

    @Override
    public void save(Estate estate) {
        persist(estate);
    }

    @Override
    public Optional<Estate> find(EstateId id) {
        return super.byId(id);
    }

    @Override
    public Optional<List<Estate>> findAll(){
        return getAll();
    }

    @Override
    public Optional<List<Estate>> findByCity(EstateCity city) {
        return findByCity(city);
    }

    @Override
    public void delete(Estate estate) {
        super.deleteEntity(estate);
    }

}
