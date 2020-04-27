package com.at.springcloud.alibaba.service;

import org.springframework.web.bind.annotation.RequestParam;

import com.at.springcloud.alibaba.domain.CommonResult;


public interface StorageService {
	
	public CommonResult<Object> decrease(@RequestParam("productId")Long productId,@RequestParam("count")Integer count);
}
