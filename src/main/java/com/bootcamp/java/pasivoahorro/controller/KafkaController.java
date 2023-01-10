package com.bootcamp.java.pasivoahorro.controller;

import com.bootcamp.java.kafka.ProductClientDTO;
import com.bootcamp.java.pasivoahorro.kafka.JsonKafkaProducer;
import com.bootcamp.java.kafka.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private JsonKafkaProducer kafkaProducer;

    public KafkaController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }

    @PostMapping("/productClientDTO")
    public ResponseEntity<String> publish(@RequestBody ProductClientDTO productClientDTO){
        kafkaProducer.sendMessageProductClient(productClientDTO);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
}
