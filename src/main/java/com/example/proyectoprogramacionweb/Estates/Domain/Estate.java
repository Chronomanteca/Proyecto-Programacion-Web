package com.example.proyectoprogramacionweb.Estates.Domain;

import com.example.proyectoprogramacionweb.Estates.Domain.ValueObjects.*;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EnterpriseId;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EstateId;

import java.util.HashMap;
import java.util.Objects;

public class Estate {
    private EstateId estateId;
    private EstatePrice price;
    private EstateType type;
    private EstateAction action;
    private EstateRoomsNumber roomsNumber;
    private EstateBathroomNumber bathroomNumber;
    private EstateArea area;
    private EstateCity city;
    private EstateAddress address;
    private EstateDescription description;
    private EnterpriseId enterpriseId;

    public Estate(EstateId estateId, EstatePrice estatePrice, EstateType estateType, EstateAction estateAction,
                  EstateRoomsNumber estateRoomsNumber, EstateBathroomNumber estateBathroomNumber,
                  EstateArea estateArea, EstateCity estateCity, EstateAddress estateAddress,
                  EstateDescription estateDescription, EnterpriseId enterpriseId) {
        this.estateId = estateId;
        this.price = estatePrice;
        this.type = estateType;
        this.action = estateAction;
        this.roomsNumber = estateRoomsNumber;
        this.bathroomNumber = estateBathroomNumber;
        this.area = estateArea;
        this.city = estateCity;
        this.address = estateAddress;
        this.description = estateDescription;
        this.enterpriseId = enterpriseId;
    }
    public static Estate Create(EstateId estateId, EstatePrice estatePrice, EstateType estateType,
                                EstateAction estateAction, EstateRoomsNumber estateRoomsNumber,
                                EstateBathroomNumber estateBathroomNumber,
                                EstateArea estateArea, EstateCity estateCity, EstateAddress estateAddress,
                                EstateDescription estateDescription,EnterpriseId enterpriseId){
        return new Estate(estateId,estatePrice,estateType,estateAction,estateRoomsNumber,estateBathroomNumber,
                estateArea,estateCity, estateAddress, estateDescription, enterpriseId);
    }

    public HashMap<String,Object> data(){
        return new HashMap<String,Object>(){{
            put("estateId",estateId.value());
            put("estatePrice",price.value());
            put("estateType", type.value());
            put("estateAction", action.value());
            put("estateRoomsNumber", roomsNumber.value());
            put("estateBathroomNumber", bathroomNumber.value());
            put("estateArea", area.value());
            put("estateCity", city.value());
            put("estateAddress", address.value());
            put("estateDescription", description.value());
            put("enterpriseId", enterpriseId.value());
        }};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estate estate = (Estate) o;
        return Objects.equals(estateId, estate.estateId) && Objects.equals(price, estate.price) && Objects.equals(type, estate.type) && Objects.equals(action, estate.action) && Objects.equals(roomsNumber, estate.roomsNumber) && Objects.equals(bathroomNumber, estate.bathroomNumber) && Objects.equals(area, estate.area) && Objects.equals(city, estate.city) && Objects.equals(address, estate.address) && Objects.equals(description, estate.description) && Objects.equals(enterpriseId, estate.enterpriseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estateId, price, type, action, roomsNumber, bathroomNumber, area, city, address, description, enterpriseId);
    }
}
