package com.at.spring.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.at.springcloud.entities.CommonResult;
import com.at.springcloud.entities.Payment;

@FeignClient(value = "cloudalibaba-nacos-provider-service",fallback = PaymentServiceFallback.class)
public interface PaymentService {
	

	@GetMapping("/provider/get/{id}")
	public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
