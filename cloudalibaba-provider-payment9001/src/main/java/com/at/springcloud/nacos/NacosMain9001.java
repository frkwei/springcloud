package com.at.springcloud.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NacosMain9001 {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(NacosMain9001.class, args);
	}

}
