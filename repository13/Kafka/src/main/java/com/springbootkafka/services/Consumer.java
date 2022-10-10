package com.springbootkafka.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
	@KafkaListener(topics = "KafkaMessage_producer", groupId = "MyGroup")
	public void listenToTopic(String recivedMessage) {
		System.out.println("This message is from producer" + recivedMessage);
	}
}