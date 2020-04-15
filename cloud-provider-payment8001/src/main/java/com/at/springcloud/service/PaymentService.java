package com.at.springcloud.service;

import org.apache.ibatis.annotations.Param;

import com.at.springcloud.entities.Payment;

public interface PaymentService {
	public int add(Payment payment);
	
	public Payment getPaymentById(@Param("id") Long id) ;
}
