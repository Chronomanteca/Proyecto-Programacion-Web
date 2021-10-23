package com.example.proyectoprogramacionweb.Estates.Infrastructure.Controllers;

import com.example.proyectoprogramacionweb.Estates.Application.Delete.EstateDeleter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Estate", description = "The Estate API")
@RequestMapping(value = "/enterprises/{enterpriseId}/properties")
public class DeleteEstateController {

    @Autowired
    EstateDeleter deleter;

    @Operation(summary = "Delete and Estate", description = "Delete an existing Estate", tags = {"Estate"})
    @DeleteMapping(value = "/{estateId}")
    public ResponseEntity execute(@PathVariable(value = "estateId") String id){
        deleter.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
