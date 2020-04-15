package com.at.sptingcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class PaymentHystrix8001 {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(PaymentHystrix8001.class, args);
	}
	
	@Bean
	public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet() {
		HystrixMetricsStreamServlet hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean<HystrixMetricsStreamServlet> bean = new ServletRegistrationBean<HystrixMetricsStreamServlet>(hystrixMetricsStreamServlet);
		bean.setLoadOnStartup(1);
		bean.addUrlMappings("/hystrix.stream");
		bean.setName("HystrixMetricsStreamServlet");
		return bean;
	}

}
