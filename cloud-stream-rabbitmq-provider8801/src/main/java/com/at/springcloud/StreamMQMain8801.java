package com.at.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableDiscoveryClient
public class StreamMQMain8801 {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(StreamMQMain8801.class, args);
	}

}
