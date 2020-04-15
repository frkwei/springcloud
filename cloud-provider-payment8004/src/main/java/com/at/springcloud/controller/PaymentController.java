package com.at.springcloud.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PaymentController {
	@Value("${server.port}")
	private String port;
	
	@RequestMapping(value = "/payment/zk")
	public String paymentzk() {
		return "springcloud with zookeeper: "+port+"\t"+UUID.randomUUID().toString();
	}
}
