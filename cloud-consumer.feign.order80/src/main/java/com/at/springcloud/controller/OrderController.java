package com.at.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.at.springcloud.entities.CommonResult;
import com.at.springcloud.entities.Payment;
import com.at.springcloud.service.PaymentFeignService;

@RestController
public class OrderController {
	//public static final String PAYMENT_URL = "http://localhost:8001";
	//public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
	@Autowired
	private PaymentFeignService paymentFeignService;
	
	@GetMapping(value = "/consumer/order/payment/{id}")
	public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
		return this.paymentFeignService.get(id);
	}
}
