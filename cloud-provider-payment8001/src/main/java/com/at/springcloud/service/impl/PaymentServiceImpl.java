package com.at.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.at.springcloud.dao.PaymentDao;
import com.at.springcloud.entities.Payment;
import com.at.springcloud.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentDao paymentDao;
	
	@Override
	public int add(Payment payment) {
		// TODO Auto-generated method stub
		return paymentDao.add(payment);
	}

	@Override
	public Payment getPaymentById(Long id) {
		// TODO Auto-generated method stub
		return paymentDao.getPaymentById(id);
	}

}
