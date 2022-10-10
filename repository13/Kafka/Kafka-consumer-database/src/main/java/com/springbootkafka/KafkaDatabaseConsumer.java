package com.springbootkafka;

import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.springbootkafka.entity.DigitalBook;
import com.springbootkafka.repo.DigitalBookRepo;

@Service
public class KafkaDatabaseConsumer {
	
	private DigitalBookRepo bookRepo;

	private static final Logger LOGGER=org.slf4j.LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
	
	@KafkaListener(topics="DigitalBook_App",groupId="myGroup")
	
	public void consume(String eventMessage) {
		
		LOGGER.info(String.format("Message Received--> %s", eventMessage));
		DigitalBook book=new DigitalBook();
		book.setDigitalBookEventData(eventMessage);
		bookRepo.save(book);
	}
}
