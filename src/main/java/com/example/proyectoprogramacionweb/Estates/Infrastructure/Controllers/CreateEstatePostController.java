package com.example.proyectoprogramacionweb.Estates.Infrastructure.Controllers;

import com.example.proyectoprogramacionweb.Estates.Application.Create.EstateCreator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name="Estate", description = "The Estate API")
@RequestMapping(value = "/enterprises/{enterpriseId}")
public class CreateEstatePostController {

    @Autowired
    private EstateCreator creator;

    @Operation(summary = "Create a new Estate", description = "Create new Estate", tags = {"Estate"})
    @PostMapping(value = "/properties")
    public ResponseEntity execute(@RequestBody EstateRequest request){
        this.creator.execute(request.getEstateId(),request.getPrice(),request.getType(),request.getAction(),
                request.getRoomsNumber(),request.getBathroomNumber(),request.getArea(),request.getCity(),
                request.getAddress(),request.getDescription(),request.getEnterpriseId());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    static class EstateRequest{
        private String estateId;
        private double price;
        private String type;
        private String action;
        private int roomsNumber;
        private int bathroomNumber;
        private double area;
        private String city;
        private String address;
        private String description;
        private String enterpriseId;

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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public int getRoomsNumber() {
            return roomsNumber;
        }

        public void setRoomsNumber(int roomsNumber) {
            this.roomsNumber = roomsNumber;
        }

        public int getBathroomNumber() {
            return bathroomNumber;
        }

        public void setBathroomNumber(int bathroomNumber) {
            this.bathroomNumber = bathroomNumber;
        }

        public double getArea() {
            return area;
        }

        public void setArea(double area) {
            this.area = area;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getEnterpriseId() {
            return enterpriseId;
        }

        public void setEnterpriseId(String enterpriseId) {
            this.enterpriseId = enterpriseId;
        }

        public EstateRequest() {
        }
    }
}
