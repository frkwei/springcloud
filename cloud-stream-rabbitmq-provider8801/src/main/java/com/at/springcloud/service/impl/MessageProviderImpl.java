package com.at.springcloud.service.impl;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import com.at.springcloud.service.IMessageProvider;
@EnableBinding(Source.class)//定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider{
	@Autowired
	private MessageChannel output;
	
	@Override
	public String send() {
		String uuid = UUID.randomUUID().toString();
		output.send(MessageBuilder.withPayload(uuid).build());
		
		System.out.println("*********uuid: "+ uuid);
		return uuid;
	}

}
