package com.example.amqp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final MessagePublisher messagePublisher;

    public TestController(MessagePublisher messagePublisher) {
        this.messagePublisher = messagePublisher;
    }

    @GetMapping("/send")
    public String send() {
        String message = "Hello, RabbitMQ TEst zzzz!";
        Load load=new Load(723803L,"Infinite Name");
        messagePublisher.sendMessage(message,load);
        return "Message sent: " + message+";Load:"+load.toString();
    }
}