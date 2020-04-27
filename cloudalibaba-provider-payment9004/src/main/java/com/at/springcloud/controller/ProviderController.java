package com.at.springcloud.controller;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.at.springcloud.entities.CommonResult;
import com.at.springcloud.entities.Payment;

@RestController
public class ProviderController {
	@Value("${server.port}")
	private String severPort;
	
	public static HashMap<Long,Payment> hashmap = new HashMap<Long, Payment>();
	
	static {
		Long i = 1l;
		for(;i<100;i++) {
			hashmap.put(i, new Payment(i,UUID.randomUUID().toString()));
		}
	}
	
	@GetMapping("/provider/get/{id}")
	public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
		Payment payment  = hashmap.get(id);
		CommonResult<Payment> result = new CommonResult<Payment>(200,"from port "+this.severPort,payment);
		return result;
	}
}
