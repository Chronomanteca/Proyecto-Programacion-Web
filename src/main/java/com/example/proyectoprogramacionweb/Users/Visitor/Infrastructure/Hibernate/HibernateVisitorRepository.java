package com.example.proyectoprogramacionweb.Users.Visitor.Infrastructure.Hibernate;

import com.example.proyectoprogramacionweb.Shared.Domain.Ids.VisitorId;
import com.example.proyectoprogramacionweb.Shared.Infrastructure.Hibernate.HibernateRepository;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.Ports.VisitorRepository;
import com.example.proyectoprogramacionweb.Users.Visitor.Domain.Visitor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class HibernateVisitorRepository extends HibernateRepository<Visitor> implements VisitorRepository {

    public HibernateVisitorRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Visitor.class);
    }

    @Override
    public void save(Visitor visitor) {
        persist(visitor);
    }

    @Override
    public Optional<Visitor> find(VisitorId id) {
        return byId(id);
    }

    @Override
    public Optional<List<Visitor>> findAll() {  return getAll(); }

}
