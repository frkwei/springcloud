package com.at.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.at.springcloud.entities.CommonResult;
import com.at.springcloud.entities.Payment;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class OrderController {
	//public static final String PAYMENT_URL = "http://localhost:8001";
	public static final String PAYMENT_URL = "http://cloud-payment-service";
	
	@Autowired
	private RestTemplate restTemplate;
	
	/*
	 * @GetMapping(value="/consumer/payment/create") public CommonResult<Payment>
	 * add(Payment payment){ System.out.println(payment+"**********"); //return
	 * null; return restTemplate.postForObject(PAYMENT_URL+"/payment/add", payment,
	 * CommonResult.class); }
	 * 
	 * @GetMapping(value="/consumer/payment/get/{id}") public CommonResult<Payment>
	 * get(@PathVariable("id") Long id){ return
	 * restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
	 * }
	 */
	
	@GetMapping(value="/consumer/payment/consul")
	public String getconsul(){
		return restTemplate.getForObject(PAYMENT_URL+"/payment/consul",String.class);
	}
}
