package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.producer.KafkaProducer;
import com.example.demo.service.impl.FormationService;

@RequestMapping(path = "/kafka/api")
@RestController
public class KafkaController {
	
	@Autowired
	private KafkaProducer kafkaProducer;
	
	@Autowired
	private FormationService formationService;
	
	@GetMapping(value = "v0")
	public void sendMessageToTopic() {
		kafkaProducer.sendMessageToTopic();
	}
	
	@GetMapping(value = "v1")
	public void sendMessageJsonToTopic() {
		
		Object objet =   (Object) formationService.getById(1L);
		kafkaProducer.sendMessageJsonToTopic(objet);
	}

}
