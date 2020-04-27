package com.at.spring.service;

import org.springframework.stereotype.Component;

import com.at.springcloud.entities.CommonResult;
import com.at.springcloud.entities.Payment;

@Component
public class PaymentServiceFallback implements PaymentService{
	@Override
	public CommonResult<Payment> paymentSQL(Long id) {
		return new CommonResult<Payment>(444,"feign fall back");
	}

}
