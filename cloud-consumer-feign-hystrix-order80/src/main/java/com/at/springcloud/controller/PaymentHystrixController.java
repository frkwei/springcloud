package com.at.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.at.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@DefaultProperties(defaultFallback = "globalMethod")
public class PaymentHystrixController {
	@Autowired
	private PaymentHystrixService paymentHystrixService;
	
	@GetMapping("/consumer/payment/hystrix/ok/{id}")
	public String paymentInfo_OK(@PathVariable("id") Integer id) {
		return this.paymentHystrixService.paymentInfo_OK1(id);
	}
	
	@GetMapping("/consumer/payment/hystrix/timeout/{id}")
	//@HystrixCommand(fallbackMethod = "fallbackMethod2",commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="200")})
	@HystrixCommand
	public String paymentInfo_TIMEOUT(@PathVariable("id") Integer id) {
		return this.paymentHystrixService.paymentInfo_TIMEOUT1(id);
	}
	
	private String fallbackMethod2(Integer id) {
		return "线程池："+Thread.currentThread().getName()+"  paymentInfo_TIMEOUT,id:  "+id+"   双刀";
	}
	
	private String globalMethod() {
		return "线程池："+Thread.currentThread().getName()+"  paymentInfo_TIMEOUT   阴阳术";
	}
}
