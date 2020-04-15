package com.at.sptingcloud.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.at.sptingcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import cn.hutool.core.util.IdUtil;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	public String paymentInfo_OK1(Integer id) {
		return "线程池："+Thread.currentThread().getName()+"  paymentInfo_OK,id:  "+id+"   大太刀";
	}
	
	@HystrixCommand(fallbackMethod = "paymentInfo_TIMEOUTHANDLER1",commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="300000")})
	public String paymentInfo_TIMEOUT1(Integer id) {
		int timeNumber = 50;
		try {
			TimeUnit.SECONDS.sleep(timeNumber);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "线程池："+Thread.currentThread().getName()+"  paymentInfo_TIMEOUT,id:  "+id+"   大太刀"+"   耗时："+timeNumber+"秒";
	}
	
	public String paymentInfo_TIMEOUTHANDLER1(Integer id) {
		return "线程池："+Thread.currentThread().getName()+"  paymentInfo_TIMEOUT,id:  "+id+"   旋棍";

	}
	
	//=====服务熔断
	
	@HystrixCommand(fallbackMethod = "paymentInfo_TIMEOUTHANDLER2",commandProperties = {
			@HystrixProperty(name="circuitBreaker.enabled",value="true"),
			@HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60"),
			@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="10000"),
			@HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),
	})
	public String paymentInfo_TIMEOUT2(Integer id) {
		if(id<0) {
			throw new RuntimeException("12314");
		}
		return "线程池："+Thread.currentThread().getName()+"  paymentInfo_TIMEOUT,id:  "+id+"   大太刀"+" "+IdUtil.simpleUUID();
	}
	
	public String paymentInfo_TIMEOUTHANDLER2(Integer id) {
		return "线程池："+Thread.currentThread().getName()+"  id不能为负数,id:  "+id+"   机关旋棍";

	}
}
