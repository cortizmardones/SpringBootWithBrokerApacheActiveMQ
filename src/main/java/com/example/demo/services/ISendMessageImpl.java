package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MessageDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ISendMessageImpl implements ISendMessage {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Override
	public void sendMessageMQ(MessageDTO message) {
		sendMessage("testQueue", message.toString());
	}

	public void sendMessage(String destination, String message) {
		jmsTemplate.convertAndSend(destination, message);
	}

	@JmsListener(destination = "testQueue2")
	public void receiveMessage(String message) {
		log.info("Received message: " + message);
		//System.out.println("Received message: " + message);
	}

}
