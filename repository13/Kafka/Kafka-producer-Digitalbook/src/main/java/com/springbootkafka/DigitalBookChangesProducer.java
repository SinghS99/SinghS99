package com.springbootkafka;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

@Service
public class DigitalBookChangesProducer {
private static final Logger LOGGER=org.slf4j.LoggerFactory.getLogger(DigitalBookChangesProducer.class);

private KafkaTemplate<String, String> kafkaTemplate;

public DigitalBookChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
	super();
	this.kafkaTemplate = kafkaTemplate;
}

public void sendMessage() throws InterruptedException {
	String topic="DigitalBook_App";
	
	//To read realtime StreamData from digitalbook
	EventHandler eventHandler=new DigitalBookChangesHandler(kafkaTemplate, topic);
	String url="http://localhost:8081/api/v1/digitalbooks/getbooks";
	EventSource.Builder builder=new EventSource.Builder(eventHandler, URI.create(url));
	EventSource eventSource=builder.build();
	eventSource.start();
	TimeUnit.MINUTES.sleep(10);
}

}
