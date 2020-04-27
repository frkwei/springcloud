package com.at.springcloud.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {
	@Value("${config.info}")
	private String configInfo;
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/configInfo/{id}")
	public String getConfigInfo(@PathVariable Integer id) {
		return this.configInfo+"    port:"+port+"    "+" id:"+id+"  "+UUID.randomUUID();
	}
}
