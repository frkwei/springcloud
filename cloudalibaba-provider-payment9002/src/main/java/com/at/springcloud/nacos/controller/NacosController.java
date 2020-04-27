package com.at.springcloud.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.core.util.IdUtil;

@RestController
public class NacosController {
	@Value("${server.port}")
	private String port;
	
	@GetMapping(value="/nacos/get")
	public String getNacosTest() {
		return this.port+" aaa"+ "  "+IdUtil.simpleUUID();
	}
}
