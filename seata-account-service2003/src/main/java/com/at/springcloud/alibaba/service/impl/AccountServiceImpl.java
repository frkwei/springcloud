package com.at.springcloud.alibaba.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.at.springcloud.alibaba.dao.AccountDao;
import com.at.springcloud.alibaba.domain.CommonResult;
import com.at.springcloud.alibaba.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public CommonResult<Object> decrease(Long userId, BigDecimal count) {
		accountDao.update(userId, count);
		return new CommonResult<Object>(200,"扣完了。。。。。");
	}

}
