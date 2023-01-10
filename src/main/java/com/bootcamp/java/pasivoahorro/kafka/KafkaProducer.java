package com.bootcamp.java.pasivoahorro.kafka;

import com.bootcamp.java.kafka.ProductClientDTO;
import com.bootcamp.java.kafka.TransactionDTO;
import com.bootcamp.java.kafka.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Value("${spring.kafka.topic-transaction.name}")
    private String topicTransaction;

    @Value("${spring.kafka.topic.productclient.name}")
    private String topicProductClientDTO;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    private KafkaTemplate<String, User> kafkaTemplateTransaction;
    private KafkaTemplate<String, ProductClientDTO> kafkaTemplateProductClientDTO;

    public KafkaProducer(KafkaTemplate<String, User> kafkaTemplateTransaction,
                         KafkaTemplate<String, ProductClientDTO> kafkaTemplateProductClientDTO) {
        this.kafkaTemplateTransaction = kafkaTemplateTransaction;
        this.kafkaTemplateProductClientDTO = kafkaTemplateProductClientDTO;
    }

    public void sendMessage(User data){

        LOGGER.info(String.format("Message sent -> %s", data.toString()));

        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topicTransaction)
                .build();

        kafkaTemplateTransaction.send(message);

    }

    public void sendMessageProductClient(ProductClientDTO data){

        LOGGER.info(String.format("Productclient Message sent -> %s", data.toString()));

        Message<ProductClientDTO> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topicProductClientDTO)
                .build();

        kafkaTemplateTransaction.send(message);

    }

    public void sendMessageTransaction(TransactionDTO data){

        LOGGER.info(String.format("TransactionDTO Message sent -> %s", data.toString()));

        Message<TransactionDTO> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topicTransaction)
                .build();

        kafkaTemplateTransaction.send(message);

    }
}
