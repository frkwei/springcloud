package com.at.sptingcloud.sentinel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.at.springcloud.entities.CommonResult;
import com.at.springcloud.entities.Payment;
import com.at.sptingcloud.sentinel.handler.CustomerBlockHandler;

@RestController
public class RateLimitController {
	@GetMapping("/byResource")
	@SentinelResource(value = "byResource",blockHandler = "handleException")
	public CommonResult<Object> byResource(){
		return new CommonResult<Object>(200,"按资源名称限流测试ok",new Payment(2020l,"支付1"));
	}
	
	public CommonResult<Object> handleException(BlockException blockException){
		return new CommonResult<Object>(444,blockException.getClass().getCanonicalName()+" 服务不可用啊");
	}
	
	@GetMapping("/byUrl")
	@SentinelResource(value = "byResource1")
	public CommonResult<Object> byUrl(){
		return new CommonResult<Object>(200,"按资源名称限流测试ok",new Payment(2020l,"支付1"));
	}
	
	@GetMapping("/customerBlockHandler")
	@SentinelResource(value = "customerBlockHandler",
					  blockHandlerClass = CustomerBlockHandler.class,
					  blockHandler = "customerBlockHandler2")
	public CommonResult<Object> customerBlockHandler(){
		return new CommonResult<Object>(200,"按客户自定限流测试ok",new Payment(2020l,"支付1"));
	}
}
