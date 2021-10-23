package com.example.proyectoprogramacionweb.Shared.Domain.Bus.Event.RabbitMQ.Serializable;

import com.example.proyectoprogramacionweb.Shared.Domain.Bus.Event.DomainEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.HashMap;

public class DomainEventJsonSerializable {

    public static String serialize(DomainEvent domainEvent){
        HashMap<String, Serializable> attributes = domainEvent.toPrimitive();
        attributes.put("id",domainEvent.aggregateId());

        HashMap<String, Serializable> message = new HashMap<>();

        message.put("data",new HashMap<String, Serializable>(){{
            put("id",domainEvent.eventId());
            put("type",domainEvent.eventName());
            put("ocurred_on", domainEvent.occurrendOn());
            put("attributes", attributes);
        }});

        message.put("meta", new HashMap<String, Serializable>());
        System.out.println("ACAAAAA " + message);
        return jsonEncode(message);
    }

    public static String jsonEncode(HashMap<String,Serializable> map){
        try {
            return new ObjectMapper().writeValueAsString(map);
        }catch (Exception e){
            return "";
        }
    }
}
