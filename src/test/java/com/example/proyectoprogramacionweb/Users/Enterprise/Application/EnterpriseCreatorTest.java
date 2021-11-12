package com.example.proyectoprogramacionweb.Users.Enterprise.Application;

import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EnterpriseId;
import com.example.proyectoprogramacionweb.Users.Enterprise.Application.Create.EnterpriseCreator;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.Enterprise;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.Ports.EnterpriseRepository;
import com.example.proyectoprogramacionweb.Users.Enterprise.Domain.ValueObjects.EnterpriseName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EnterpriseCreatorTest {
    Enterprise enterprise;
    EnterpriseRepository repository;

    @BeforeEach
    void setup(){
        this.enterprise = new Enterprise(new EnterpriseId("d8e1737a-fb41-4803-84ed-6d46cb96560a"),
                new EnterpriseName("Empresa1"));
        this.repository = Mockito.mock(EnterpriseRepository.class);
    }

    @Test
    void should_create(){
        EnterpriseCreator creator = new EnterpriseCreator(repository);
        creator.execute("d8e1737a-fb41-4803-84ed-6d46cb96560a", "Empresa1");
        Mockito.verify(repository,Mockito.atLeastOnce()).save(enterprise);
    }
}
