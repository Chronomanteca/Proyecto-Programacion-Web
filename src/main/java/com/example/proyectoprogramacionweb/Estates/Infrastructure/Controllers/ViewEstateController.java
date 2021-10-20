package com.example.proyectoprogramacionweb.Estates.Infrastructure.Controllers;

import com.example.proyectoprogramacionweb.Estates.Domain.Estate;
import com.example.proyectoprogramacionweb.Estates.Infrastructure.Hibernate.HibernateEstateRepository;
import com.example.proyectoprogramacionweb.Shared.Domain.Aggregate.CustomUUID;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EstateId;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ViewEstateController {

    @Autowired
    private HibernateEstateRepository repo;

    @Operation(summary = "Gets the selected estate data to be shown in the Frontend", tags = {"Estate", "View"})
    @GetMapping(value = "/estates/{estateId}")
    public @ResponseBody ResponseEntity<Estate> getEstate(@PathVariable String estateId) {
        Optional<Estate> selectedEstate = repo.find(new EstateId(estateId));

        if(selectedEstate.isPresent()){
            return new ResponseEntity<>(selectedEstate.get(), HttpStatus.FOUND);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
