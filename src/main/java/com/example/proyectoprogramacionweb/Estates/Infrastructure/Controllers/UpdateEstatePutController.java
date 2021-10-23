package com.example.proyectoprogramacionweb.Estates.Infrastructure.Controllers;

import com.example.proyectoprogramacionweb.Estates.Application.Update.EstateActionUpdater;
import com.example.proyectoprogramacionweb.Estates.Application.Update.EstateDescriptionUpdater;
import com.example.proyectoprogramacionweb.Estates.Application.Update.EstatePriceUpdater;
import com.example.proyectoprogramacionweb.Estates.Domain.Estate;
import com.example.proyectoprogramacionweb.Estates.Domain.Ports.EstateRepository;
import com.example.proyectoprogramacionweb.Estates.Domain.Services.DomainEstateFinder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
