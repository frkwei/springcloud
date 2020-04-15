package com.at.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.at.springcloud.service.impl.PaymentHystrixFallbackService;

@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE",fallback = PaymentHystrixFallbackService.class)
@Component
public interface PaymentHystrixService {
	@GetMapping("/payment/hystrix/ok/{id}")
	public String paymentInfo_OK1(@PathVariable("id") Integer id);
	
	
	@GetMapping("/payment/hystrix/timeout/{id}")
	public String paymentInfo_TIMEOUT1(@PathVariable("id") Integer id);
		
}
