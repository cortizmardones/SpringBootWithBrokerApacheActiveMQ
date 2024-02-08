package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MessageDTO;
import com.example.demo.services.ISendMessage;

@RestController
@RequestMapping("/activemq/v1")
public class MiControllerMQ {
	
	@Autowired
	private ISendMessage isendMessage;
	
	@PostMapping("/sendMessage")
	public void sendMessage(@RequestBody MessageDTO message) {
		isendMessage.sendMessageMQ(message);
	}
	

}
