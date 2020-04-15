package com.at.springcloud.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.at.springcloud.entities.CommonResult;
import com.at.springcloud.entities.Payment;
import com.at.springcloud.lb.LoadBancer;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class OrderController {
	//public static final String PAYMENT_URL = "http://localhost:8001";
	//public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
	public static final String PAYMENT_URL = "http://CLOUD-GATEWAY";
	//public static final String PAYMENT_URL = "http://localhost:9527";
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBancer loadBancer;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping(value="/cunsmer/payment/create")
	public CommonResult<Payment> add(Payment payment){
		System.out.println(payment+"**********");
		//return null;
		return restTemplate.postForObject(PAYMENT_URL+"/payment/add", payment, CommonResult.class);
	}
	@GetMapping(value="/cunsmer/payment/get/{id}")
	public CommonResult<Payment> get(@PathVariable("id") Long id){
		ResponseEntity<CommonResult>  responseEntity = restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
		
		return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
	}
	
	@GetMapping(value="/consumer/payment/lb")
	public String getPaymentLB() {
		List<ServiceInstance> serviceInstances = this.discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
		if(serviceInstances==null||serviceInstances.size()==0) {
			return null;
		}
		
		URI uri = this.loadBancer.instances(serviceInstances).getUri();
		
		return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+12,String.class);
		//return restTemplate.getForObject(uri+"/payment/get/12", String.class);
	}
	
	@GetMapping(value="/payment/get/geteway/get/{id}")
	public String getGateway2(@PathVariable Integer id) {
		String a = "?uname=1";
		return restTemplate.getForObject(PAYMENT_URL+"/payment/get/geteway/get/"+12+a,String.class);
	}
}
