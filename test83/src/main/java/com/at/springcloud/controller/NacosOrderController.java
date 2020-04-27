package com.at.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NacosOrderController {
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${service-url.nacos-user-service}")
	private String serverUrl;
	
	@GetMapping(value="/testC")
	public String getNacosResult() {
		return restTemplate.getForObject(serverUrl+"/testA", String.class)+"    C";
	}
	
	@GetMapping(value="/testD")
	public String getNacosResult2() {
		return restTemplate.getForObject(serverUrl+"/testA", String.class)+"     D";
	}
}
