package com.example.proyectoprogramacionweb.Shared.Domain.Bus.Event.RabbitMQ;

import com.example.proyectoprogramacionweb.Shared.Domain.Bus.Event.DomainEvent;
import com.example.proyectoprogramacionweb.Shared.Domain.Bus.Event.RabbitMQ.Serializable.DomainEventJsonSerializable;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public final class RabbitMqPublisher {

    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public RabbitMqPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publish(DomainEvent domainEvent, String exchangeName){
        String serializedDomainEvent = DomainEventJsonSerializable.serialize(domainEvent);
        Message message = new Message(
                serializedDomainEvent.getBytes(),
                MessagePropertiesBuilder.newInstance()
                        .setContentEncoding("uft-8")
                        .setContentType("application/json").build()
        );

        rabbitTemplate.send(exchangeName, "appointment.create", message);
    }
}
