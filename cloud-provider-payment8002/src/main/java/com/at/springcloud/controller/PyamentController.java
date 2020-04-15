package com.at.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.at.springcloud.entities.CommonResult;
import com.at.springcloud.entities.Payment;
import com.at.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PyamentController {
	@Autowired
	private PaymentService paymentService;
	
	@Value("${server.port}")
	private String serverPort;
	
	@PostMapping(value="/payment/add")
	public CommonResult<Integer> add(@RequestBody Payment payment) {
		System.out.println(payment+"------------------");
		int result = paymentService.add(payment);
		log.info("**********result="+result);
		if(result>0) {
			return new CommonResult<Integer>(200,"success11,serverPort:"+serverPort,result);
		}else {
			return new CommonResult<Integer>(500,"failed",null);
		}
	}
	
	@GetMapping(value="/payment/get/{id}")
	public CommonResult<Payment> get(@PathVariable("id") Long id) {
		Payment result = paymentService.getPaymentById(id);
		log.info("**********result="+result);
		if(result!=null) {
			return new CommonResult<Payment>(200,"success111,serverPort:"+serverPort,result);
		}else {
			return new CommonResult<Payment>(500,"failed",null);
		}
	}
	
	@GetMapping(value="/payment/lb/geteway")
	public String getGateway() {
		return this.serverPort;
	}
	
	@GetMapping(value="/payment/get/geteway/get/{id}")
	public String getGateway2(@PathVariable Integer id) {
		return this.serverPort+"  get到了id："+id;
	}
}
