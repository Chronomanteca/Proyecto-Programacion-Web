package com.example.proyectoprogramacionweb.Estates.Estate.Infrastructure.Controllers;

import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Estate;
import com.example.proyectoprogramacionweb.Estates.Estate.Infrastructure.Hibernate.HibernateEstateRepository;
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
    public @ResponseBody ResponseEntity<EstateRequest> getEstate(@PathVariable String estateId) {
        Optional<Estate> selectedEstate = repo.find(new EstateId(estateId));
        EstateRequest selectedEstateRequest;

        if(selectedEstate.isPresent()){
            selectedEstateRequest = new EstateRequest((String)selectedEstate.get().data().get("estateId"),
                    (Double)selectedEstate.get().data().get("estatePrice"),
                    (String)selectedEstate.get().data().get("estateType"),
                    (String)selectedEstate.get().data().get("estateAction"),
                    (Integer)selectedEstate.get().data().get("estateRoomsNumber"),
                    (Integer)selectedEstate.get().data().get("estateBathroomNumber"),
                    (Double)selectedEstate.get().data().get("estateArea"),
                    (String)selectedEstate.get().data().get("estateCity"),
                    (String)selectedEstate.get().data().get("estateAddress"),
                    (String)selectedEstate.get().data().get("estateDescription"),
                    (String)selectedEstate.get().data().get("estateEnterpriseId"));

            return new ResponseEntity<>(selectedEstateRequest, HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    public static class EstateRequest{
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

        public EstateRequest() {
        }

        public EstateRequest(String estateId, double price, String type, String action, int roomsNumber, int bathroomNumber, double area, String city, String address, String description, String enterpriseId) {
            this.estateId = estateId;
            this.price = price;
            this.type = type;
            this.action = action;
            this.roomsNumber = roomsNumber;
            this.bathroomNumber = bathroomNumber;
            this.area = area;
            this.city = city;
            this.address = address;
            this.description = description;
            this.enterpriseId = enterpriseId;
        }

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
    }
}
