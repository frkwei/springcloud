package com.at.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class MyRule1 {

	@Bean
	public IRule myRule() {
		return new RandomRule();//定义为随机规则
	}
}
