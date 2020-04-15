package com.at.springcloud.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PaymentController {
	@Value("${server.port}")
	private String port;
	
	@RequestMapping(value = "/payment/consul")
	public String paymentconsul() {
		return "springcloud with consul: "+port+"\t"+UUID.randomUUID().toString();
	}
}
