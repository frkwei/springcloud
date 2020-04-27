package com.at.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.at.springcloud.alibaba.domain.CommonResult;
import com.at.springcloud.alibaba.service.StorageService;

@RestController
public class StorageController {
	@Autowired
	private StorageService storageService;
	
	@RequestMapping("/storage/decrease")
	public CommonResult<Object> decrease(Long productId, Integer count){
		return storageService.decrease(productId, count);
	}
}
