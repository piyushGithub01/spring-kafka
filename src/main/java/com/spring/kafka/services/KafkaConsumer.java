package com.spring.kafka.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.spring.kafka.model.OrderCreatedEvent;
import com.spring.kafka.storage.EventStorage;

@Service
public class KafkaConsumer {
	
	@Autowired
	private EventStorage eventStorage;
	
	@KafkaListener(topics="${kafka.topic}")
    public void processMessage(OrderCreatedEvent event) {
		System.out.println("received content = " + event);
		eventStorage.put(event);
    }
}
