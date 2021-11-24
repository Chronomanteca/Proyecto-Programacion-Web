package com.example.proyectoprogramacionweb.Estates.Estate.Application.Find;

import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Estate;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Exceptions.EstateNotFound;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Exceptions.EstateNotFoundByCity;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Ports.EstateRepository;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.ValueObjects.*;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EnterpriseId;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EstateId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class EstateFindTest {

    Estate estate;
    List<Estate> list;
    EstateRepository repository;

    @BeforeEach
    void setup(){
        this.estate = new Estate(new EstateId("dc5b86e0-2a6a-4e55-89bc-290d95b296f3"), new EstatePrice(5000d),
                new EstateType("Apartment"), new EstateAction("rent"), new EstateRoomsNumber(5),
                new EstateBathroomNumber(3), new EstateArea(150d), new EstateCity("Bogota"),
                new EstateAddress("Calle 1#4-48"), new EstateDescription("Apto bonito"),
                new EnterpriseId("df4d35cd-f67a-45ef-9a33-5cadf1b29969"), null);
        this.repository = Mockito.mock(EstateRepository.class);
        this.list = new ArrayList<Estate>();
        list.add(estate);
        Mockito.when(repository.find(new EstateId("dc5b86e0-2a6a-4e55-89bc-290d95b296f3")))
                .thenReturn(Optional.of(estate));
        Mockito.when(repository.findByCity(new EstateCity("Bogota"))).thenReturn(Optional.of(list));
    }
    @Test
    void should_find_estate_byId(){
        EstateFinder finder = new EstateFinder(repository);
        Assertions.assertEquals(finder.execute("dc5b86e0-2a6a-4e55-89bc-290d95b296f3"),estate);
    }
    @Test
    void should_find_byCity(){
        EstateCityFinder finder = new EstateCityFinder(repository);
        Assertions.assertEquals(finder.execute("Bogota"),list);
    }
    @Test
    void should_not_find_byCity(){
        EstateCityFinder finder = new EstateCityFinder(repository);
        Assertions.assertThrows(EstateNotFoundByCity.class, () ->{
            finder.execute("Medellin");
        });
    }
    @Test
    void should_not_find_byId(){
        EstateFinder finder = new EstateFinder(repository);
        Assertions.assertThrows(EstateNotFound.class, () ->{
            finder.execute("ef4be5e1-e3b0-4ef0-8e31-68896546858e");
        });
    }
}
