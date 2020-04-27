package com.at.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StreanMQMain8803 {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(StreanMQMain8803.class, args);
	}

}
