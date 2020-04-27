package com.at.sptingcloud.sentinel.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.at.springcloud.entities.CommonResult;

public class CustomerBlockHandler {
	public static CommonResult<Object> customerBlockHandler(BlockException blockException){
		return new CommonResult<Object>(444,"按客户自定限流测试失败globel  --------------1");
	}
	
	public static CommonResult<Object> customerBlockHandler2(BlockException blockException){
		return new CommonResult<Object>(444,"按客户自定限流测试失败globel  --------------2");
	}
}
