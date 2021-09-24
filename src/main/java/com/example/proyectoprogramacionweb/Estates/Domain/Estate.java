package com.example.proyectoprogramacionweb.Estates.Domain;

import com.example.proyectoprogramacionweb.Estates.Domain.ValueObjects.*;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EstateId;

import java.util.HashMap;
import java.util.Objects;

public class Estate {
    private EstateId estateId;
    private EstatePrice estatePrice;
    private EstateType estateType;
    private EstateAction estateAction;
    private EstateRoomsNumber estateRoomsNumber;
    private EstateBathroomNumber estateBathroomNumber;
    private EstateArea estateArea;
    private EstateCity estateCity;

    public Estate(EstateId estateId, EstatePrice estatePrice, EstateType estateType, EstateAction estateAction,
                  EstateRoomsNumber estateRoomsNumber, EstateBathroomNumber estateBathroomNumber,
                  EstateArea estateArea, EstateCity estateCity) {
        this.estateId = estateId;
        this.estatePrice = estatePrice;
        this.estateType = estateType;
        this.estateAction = estateAction;
        this.estateRoomsNumber = estateRoomsNumber;
        this.estateBathroomNumber = estateBathroomNumber;
        this.estateArea = estateArea;
        this.estateCity = estateCity;
    }
    public static Estate Create(EstateId estateId, EstatePrice estatePrice, EstateType estateType,
                                EstateAction estateAction, EstateRoomsNumber estateRoomsNumber,
                                EstateBathroomNumber estateBathroomNumber,
                                EstateArea estateArea, EstateCity estateCity){
        return new Estate(estateId,estatePrice,estateType,estateAction,estateRoomsNumber,estateBathroomNumber,
                estateArea,estateCity);
    }

    public HashMap<String,Object> data(){
        return new HashMap<String,Object>(){{
            put("estateId",estateId.value());
            put("estatePrice",estatePrice.value());
            put("estateType",estateType.value());
            put("estateAction",estateAction.value());
            put("estateRoomsNumber",estateRoomsNumber.value());
            put("estateBathroomNumber",estateBathroomNumber.value());
            put("estateArea",estateArea.value());
            put("estateCity",estateCity.value());
        }};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estate estate = (Estate) o;
        return Objects.equals(estateId, estate.estateId) && Objects.equals(estatePrice, estate.estatePrice) && Objects.equals(estateType, estate.estateType) && Objects.equals(estateAction, estate.estateAction) && Objects.equals(estateRoomsNumber, estate.estateRoomsNumber) && Objects.equals(estateBathroomNumber, estate.estateBathroomNumber) && Objects.equals(estateArea, estate.estateArea) && Objects.equals(estateCity, estate.estateCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estateId, estatePrice, estateType, estateAction, estateRoomsNumber, estateBathroomNumber, estateArea, estateCity);
    }
}
