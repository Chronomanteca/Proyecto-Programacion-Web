package com.example.proyectoprogramacionweb.Estates.Domain;

import com.example.proyectoprogramacionweb.Estates.Domain.Entities.EstateAppointment;
import com.example.proyectoprogramacionweb.Estates.Domain.ValueObjects.*;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EnterpriseId;
import com.example.proyectoprogramacionweb.Shared.Domain.Ids.EstateId;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    private List<EstateAppointment> appointments;

    public Estate() {
    }

    public Estate(EstateId estateId, EstatePrice price, EstateType type, EstateAction action,
                  EstateRoomsNumber roomsNumber, EstateBathroomNumber bathroomNumber, EstateArea area,
                  EstateCity city, EstateAddress address, EstateDescription description,
                  EnterpriseId enterpriseId, List<EstateAppointment> appointments) {
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
        this.appointments = appointments;
    }

    public static Estate Create(EstateId estateId, EstatePrice estatePrice, EstateType estateType,
                                EstateAction estateAction, EstateRoomsNumber estateRoomsNumber,
                                EstateBathroomNumber estateBathroomNumber,
                                EstateArea estateArea, EstateCity estateCity, EstateAddress estateAddress,
                                EstateDescription estateDescription, EnterpriseId enterpriseId){
        return new Estate(estateId,estatePrice,estateType,estateAction,estateRoomsNumber,estateBathroomNumber,
                estateArea,estateCity, estateAddress, estateDescription,
                enterpriseId,null);
    }

    public void updatePrice(EstatePrice price){
        this.price = price;
    }

    public void updateAction(EstateAction action){
        this.action = action;
    }

    public void updateDescription(EstateDescription description){
        this.description = description;
    }

    public HashMap<String,Object> data(){
        HashMap<String,Object> data = new HashMap<>(){{
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
            put("estateEnterpriseId", enterpriseId.value()); //Agregado por RAMO, no se si de les habia olvidado ponerlo o si simplemente por diseño no se podia poner ahí
        }};
        data.putAll(dataAppointmets());
        return data;
    }
    public HashMap<String,Object> dataAppointmets(){
        HashMap<String, Object> data = new HashMap<>();
        data.replace("appointments", null);
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estate estate = (Estate) o;
        return Objects.equals(estateId, estate.estateId) && Objects.equals(price, estate.price) && Objects.equals(type, estate.type) && Objects.equals(action, estate.action) && Objects.equals(roomsNumber, estate.roomsNumber) && Objects.equals(bathroomNumber, estate.bathroomNumber) && Objects.equals(area, estate.area) && Objects.equals(city, estate.city) && Objects.equals(address, estate.address) && Objects.equals(description, estate.description) && Objects.equals(enterpriseId, estate.enterpriseId) && Objects.equals(appointments, estate.appointments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estateId, price, type, action, roomsNumber, bathroomNumber, area, city, address, description, enterpriseId, appointments);
    }
}
