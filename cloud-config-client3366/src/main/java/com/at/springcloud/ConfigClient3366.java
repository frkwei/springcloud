package com.at.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClient3366 {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ConfigClient3366.class, args);
	}

}
