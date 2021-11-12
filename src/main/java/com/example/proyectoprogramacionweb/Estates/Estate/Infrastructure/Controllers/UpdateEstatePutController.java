package com.example.proyectoprogramacionweb.Estates.Estate.Infrastructure.Controllers;

import com.example.proyectoprogramacionweb.Estates.Estate.Application.Update.EstateActionUpdater;
import com.example.proyectoprogramacionweb.Estates.Estate.Application.Update.EstateDescriptionUpdater;
import com.example.proyectoprogramacionweb.Estates.Estate.Application.Update.EstatePriceUpdater;
import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Exceptions.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Tag(name="Estate", description = "The Estate API")
@RequestMapping(value = "/enterprises/{enterpriseId}/properties/{estateId}")
public class UpdateEstatePutController {

    @Autowired
    private EstatePriceUpdater priceUpdater;
    @Autowired
    private EstateDescriptionUpdater descriptionUpdater;
    @Autowired
    private EstateActionUpdater actionUpdater;

    @Operation(summary = "Update an existing Estate", description = "Update Estate", tags = {"Estate"})
    @PutMapping(value = "/")
    public ResponseEntity execute(@RequestBody EstateUpdateRequest request){
        priceUpdater.execute(request.estateId, request.price);
        descriptionUpdater.execute(request.estateId, request.description);
        actionUpdater.execute(request.estateId, request.action);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler({InvalidEstateAction.class, InvalidEstatePrice.class, InvalidEstateDescription.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleBadRequest(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    static class EstateUpdateRequest{
        private String estateId;
        private double price;
        private String action;
        private String description;

        public String getEstateId() {
            return estateId;
        }

        public void setEstateId(String estateId) {
            this.estateId = estateId;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public EstateUpdateRequest() {
        }
    }
}
