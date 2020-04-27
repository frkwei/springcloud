package com.at.springcloud.alibaba.service;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.at.springcloud.alibaba.domain.CommonResult;

@FeignClient(value = "seata-account-service")
@SuppressWarnings("rawtypes")
public interface AccountService {
	@PostMapping(value="/account/decrease")
	public CommonResult decrease(@RequestParam("userId")Long userId,@RequestParam("money")BigDecimal money);
}
