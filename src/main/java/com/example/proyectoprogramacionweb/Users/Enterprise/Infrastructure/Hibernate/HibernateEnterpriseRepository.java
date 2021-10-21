package com.example.proyectoprogramacionweb.Users.Enterprise.Infrastructure.Hibernate;

import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EnterpriseId;
import com.example.proyectoprogramacionweb.Shared.Infrastructure.Hibernate.HibernateRepository;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.Enterprise;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.Ports.EnterpriseRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.transaction.Transactional;

@Transactional
public class HibernateEnterpriseRepository extends HibernateRepository<Enterprise> implements EnterpriseRepository {
    public HibernateEnterpriseRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Enterprise.class);
    }

    @Override
    public void save(Enterprise enterprise) {
        persist(enterprise);
    }

    @Override
    public Enterprise find(EnterpriseId id) {
        return find(id);
    }
}
