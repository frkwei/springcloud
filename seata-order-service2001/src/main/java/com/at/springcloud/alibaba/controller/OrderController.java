package com.at.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.at.springcloud.alibaba.domain.CommonResult;
import com.at.springcloud.alibaba.domain.Order;
import com.at.springcloud.alibaba.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/order/create")
	public CommonResult<Order> create(Order order){
		orderService.create(order);
		return new CommonResult<Order>(200,"创建订单完成",order);
	}
}
