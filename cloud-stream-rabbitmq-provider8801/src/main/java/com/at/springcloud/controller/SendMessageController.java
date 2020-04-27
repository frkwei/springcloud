package com.at.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.at.springcloud.service.IMessageProvider;

@RestController
public class SendMessageController {
	@Autowired
	private IMessageProvider messageProvider;
	
	@GetMapping("/message/send")
	public String sendMessage() {
		return messageProvider.send();
	}
}
