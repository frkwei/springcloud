package com.at.springcloud.service.impl;

import org.springframework.stereotype.Service;

import com.at.springcloud.service.PaymentHystrixService;

@Service
public class PaymentHystrixFallbackService implements PaymentHystrixService {

	@Override
	public String paymentInfo_OK1(Integer id) {
		// TODO Auto-generated method stub
		return "PaymentHystrixFallbackService paymentInfo_OK1 fall back ";
	}

	@Override
	public String paymentInfo_TIMEOUT1(Integer id) {
		// TODO Auto-generated method stub
		return "PaymentHystrixFallbackService paymentInfo_TIMEOUT1 fall back ";
	}

}
