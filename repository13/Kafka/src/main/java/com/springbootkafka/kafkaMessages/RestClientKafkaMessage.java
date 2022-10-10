package com.springbootkafka.kafkaMessages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootkafka.services.Producer;

@RestController
@RequestMapping("api/rest")
public class RestClientKafkaMessage {

	@Autowired
	private Producer producer;

	@GetMapping("/producermsg")
	public void getMessageFromClient(@RequestParam("message") String message) {
		producer.sendMsgToConsumer(message);
	}
}