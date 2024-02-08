package com.example.demo.services;

import com.example.demo.dto.MessageDTO;

public interface ISendMessage {
	
	public void sendMessageMQ(MessageDTO message);

}
