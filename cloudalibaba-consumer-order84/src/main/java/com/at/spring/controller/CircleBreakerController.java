package com.at.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.at.springcloud.entities.CommonResult;
import com.at.springcloud.entities.Payment;

@RestController
public class CircleBreakerController {
	private static String Service_Url = "http://cloudalibaba-nacos-provider-service";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/consumer/fallback/{id}")
	//@SentinelResource(value = "fallback")
	//@SentinelResource(value = "fallback",fallback = "handlerFallback") //fallback只负责业务异常
	//@SentinelResource(value = "fallback",blockHandler = "handlerBlock")//blockHandler只负责sentinel控制台配置的违规
	@SentinelResource(value = "fallback",blockHandler = "handlerBlock",fallback = "handlerFallback")
	public CommonResult<Payment> fallback(@PathVariable Long id){
		CommonResult<Payment> commonResult = this.restTemplate.getForObject(this.Service_Url+"/provider/get/"+id, CommonResult.class,id);
		if(id==4) {
			throw new IllegalArgumentException("IllegalArgumentException ,非法参数异常...");
		}else if(commonResult.getData()==null) {
			throw new NullPointerException("NullPointerException ,没有对应的记录...");
		}
		return commonResult;
	}
	
	
//	本例是fallback
	public CommonResult<Payment> handlerFallback(@PathVariable Long id,Throwable e){
		Payment payment =new Payment(id,null);
		return new CommonResult<Payment>(444,"兜底方法handlerFallback，异常内容："+e.getMessage(),payment);
	}
	
//	本例是Block
	public CommonResult<Payment> handlerBlock(@PathVariable Long id,BlockException e){
		Payment payment =new Payment(id,null);
		return new CommonResult<Payment>(445,"兜底方法handlerBlock，异常内容："+e.getMessage(),payment);
	}
}
