package com.example.amqp;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessagePublisher {

    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange exchange;

    public MessagePublisher(RabbitTemplate rabbitTemplate, DirectExchange exchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
    }

    public void sendMessage(String message,Load load) {
        MyMessage mesaj=new MyMessage();
        mesaj.setContent("Hello RabbitMQ");
        mesaj.setLoad(load);
        mesaj.setPriority(7);
        rabbitTemplate.convertAndSend(exchange.getName(), ProducerConfig.ROUTING_KEY, mesaj);
        System.out.println("Sent message: " + mesaj.toString());
    }
}