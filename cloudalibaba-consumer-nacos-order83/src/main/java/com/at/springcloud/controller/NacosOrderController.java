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
	
	@GetMapping(value="/order/get")
	public String getNacosResult() {
		return restTemplate.getForObject(serverUrl+"/nacos/get", String.class);
	}
}
