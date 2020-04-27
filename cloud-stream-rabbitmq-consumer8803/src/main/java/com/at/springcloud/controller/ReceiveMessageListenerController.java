package com.at.springcloud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {
	
	public static List<String> list = new ArrayList<String>();
	
	@Value("${server.port}")
	private String port;
	
	@StreamListener(Sink.INPUT)
	public void input(Message<String> message) {
		String str = "我是2号，端口号是："+port+"，接收到的消息是："+message.getPayload();
		System.out.println(str);
		ReceiveMessageListenerController.list.add(str);
	}
	
	@GetMapping("/getM")
	public String getMessage() {
		String result = "收到以下消息："+"<br>";
		for(String s : list) {
			result+=s+"<br>";
		}
		return result;
	}
}
