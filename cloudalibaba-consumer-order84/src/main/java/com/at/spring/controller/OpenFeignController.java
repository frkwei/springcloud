package com.at.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.at.spring.service.PaymentService;
import com.at.springcloud.entities.CommonResult;
import com.at.springcloud.entities.Payment;

@RestController
public class OpenFeignController {
	@Autowired
	public PaymentService paymentService;
	
	@GetMapping("/get/{id}")
	public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
		return this.paymentService.paymentSQL(id);
	}
}
