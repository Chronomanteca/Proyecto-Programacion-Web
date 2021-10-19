package com.example.proyectoprogramacionweb.Estates.Estate.Application.Create;

import com.example.proyectoprogramacionweb.Estates.Application.Create.EstateCreator;
import com.example.proyectoprogramacionweb.Estates.Domain.Estate;
import com.example.proyectoprogramacionweb.Estates.Domain.Exceptions.*;
import com.example.proyectoprogramacionweb.Estates.Domain.Ports.EstateRepository;
import com.example.proyectoprogramacionweb.Estates.Domain.ValueObjects.*;
import com.example.proyectoprogramacionweb.Shared.Domain.Exceptions.UUIDNotValid;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EnterpriseId;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EstateId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class EstateCreatorTest {

    Estate estate;
    EstateRepository repository;

    @BeforeEach
    void setup(){
        this.estate = new Estate(new EstateId("dc5b86e0-2a6a-4e55-89bc-290d95b296f3"), new EstatePrice(5000d),
                new EstateType("Apartment"), new EstateAction("rent"), new EstateRoomsNumber(5),
                new EstateBathroomNumber(3), new EstateArea(150d), new EstateCity("Bogotá"),
                new EstateAddress("Calle 1#4-48"), new EstateDescription("Apto bonito"),
                new EnterpriseId("df4d35cd-f67a-45ef-9a33-5cadf1b29969"), null);
        this.repository = Mockito.mock(EstateRepository.class);
    }

    @Test
    void should_create_estate(){
        EstateCreator creator = new EstateCreator(repository);
        creator.execute("dc5b86e0-2a6a-4e55-89bc-290d95b296f3",5000d,"Apartment","rent",
                5,3,150d,"Bogotá","Calle 1#4-48","Apto bonito",
                "4449d12e-2dbd-4d6c-abb2-e374e232f33c");
        Mockito.verify(repository,  Mockito.atLeastOnce()).save(estate);
    }

    @Test
    void should_not_create_estate_not_valid_id(){
        EstateCreator creator = new EstateCreator(repository);
        Assertions.assertThrows(UUIDNotValid.class, () ->{
            creator.execute("dc5b86e0-2a6a-4e55-290d95b296f3",5000d,"Apartment","rent",
                    5,3,150d,"Bogotá","Calle 1#4-48","Apto bonito",
                    "4449d12e-2dbd-4d6c-abb2-e374e232f33c");
        });
    }
    @Test
    void not_create_invalid_price(){
        EstateCreator creator = new EstateCreator(repository);
        Assertions.assertThrows(InvalidEstatePrice.class, () ->{
            creator.execute("dc5b86e0-2a6a-4e55-89bc-290d95b296f3",0d,"Apartment","rent",
                    5,3,150d,"Bogotá","Calle 1#4-48","Apto bonito",
                    "4449d12e-2dbd-4d6c-abb2-e374e232f33c");
        });
    }
    @Test
    void not_create_invalid_area(){
        EstateCreator creator = new EstateCreator(repository);
        Assertions.assertThrows(InvalidEstateArea.class, () ->{
            creator.execute("dc5b86e0-2a6a-4e55-89bc-290d95b296f3",5000d,"Apartment","rent",
                    5,3,0d,"Bogotá","Calle 1#4-48","Apto bonito",
                    "4449d12e-2dbd-4d6c-abb2-e374e232f33c");
        });
    }
    @Test
    void not_create_invalid_bathroom_number(){
        EstateCreator creator = new EstateCreator(repository);
        Assertions.assertThrows(InvalidEstateBathroomNumber.class, () ->{
            creator.execute("dc5b86e0-2a6a-4e55-89bc-290d95b296f3",5000d,"Apartment","rent",
                    5,0,150d,"Bogotá","Calle 1#4-48","Apto bonito",
                    "4449d12e-2dbd-4d6c-abb2-e374e232f33c");
        });
    }
    @Test
    void not_create_invalid_rooms_number(){
        EstateCreator creator = new EstateCreator(repository);
        Assertions.assertThrows(InvalidEstateRoomsNumber.class, () ->{
            creator.execute("dc5b86e0-2a6a-4e55-89bc-290d95b296f3",5000d,"Apartment","rent",
                    0,3,150d,"Bogotá","Calle 1#4-48","Apto bonito",
                    "4449d12e-2dbd-4d6c-abb2-e374e232f33c");
        });
    }
    @Test
    void not_create_invalid_action(){
        EstateCreator creator = new EstateCreator(repository);
        Assertions.assertThrows(InvalidEstateAction.class, () ->{
            creator.execute("dc5b86e0-2a6a-4e55-89bc-290d95b296f3",5000d,"Apartment","hipotecar",
                    5,3,150d,"Bogotá","Calle 1#4-48","Apto bonito",
                    "4449d12e-2dbd-4d6c-abb2-e374e232f33c");
        });
    }
}
