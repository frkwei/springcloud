package com.at.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.at.springcloud.entities.CommonResult;
import com.at.springcloud.entities.Payment;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
	@GetMapping(value="/payment/get/{id}")
	public CommonResult<Payment> get(@PathVariable("id") Long id);
}
