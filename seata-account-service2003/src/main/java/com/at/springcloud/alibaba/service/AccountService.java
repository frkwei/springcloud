package com.at.springcloud.alibaba.service;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;

import com.at.springcloud.alibaba.domain.CommonResult;


public interface AccountService {
	
	public CommonResult<Object> decrease(Long userId,BigDecimal count);
}
