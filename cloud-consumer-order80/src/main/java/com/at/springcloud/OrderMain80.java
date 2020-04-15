package com.at.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.at.myrule.MyRule1;

@SpringBootApplication
//@RibbonClient(name="CLOUD-PAYMENT-SERVICE",configuration = MyRule1.class)
public class OrderMain80 {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(OrderMain80.class, args);
	}

}
