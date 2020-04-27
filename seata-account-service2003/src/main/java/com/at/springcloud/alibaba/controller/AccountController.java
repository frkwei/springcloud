package com.at.springcloud.alibaba.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.at.springcloud.alibaba.domain.CommonResult;
import com.at.springcloud.alibaba.service.AccountService;

@RestController
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/account/decrease",method=RequestMethod.POST)
	public CommonResult<Object> decrease(@RequestParam("userId")Long userId,@RequestParam("money")BigDecimal money) {
		return this.accountService.decrease(userId, money);
	}
}
