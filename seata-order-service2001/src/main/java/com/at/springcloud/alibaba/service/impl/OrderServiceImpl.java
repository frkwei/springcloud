package com.at.springcloud.alibaba.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.at.springcloud.alibaba.dao.OrderDao;
import com.at.springcloud.alibaba.domain.CommonResult;
import com.at.springcloud.alibaba.domain.Order;
import com.at.springcloud.alibaba.service.AccountService;
import com.at.springcloud.alibaba.service.OrderService;
import com.at.springcloud.alibaba.service.StorageService;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService{
	@Autowired
	private StorageService storageService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private OrderDao orderDao;
	
	@Override
	@GlobalTransactional(name="test-create-order",rollbackFor = Exception.class)
	public void create(Order order) {
		log.info("------------>开始新建订单");
		orderDao.createOrder(order);
		log.info("------------>订单微服务开始调用【库存】，做扣减");
		CommonResult<Object> commonResult = storageService.decrease(order.getProductId(), order.getCount());
		if(commonResult.getCode()==555) {
			log.info("------------>"+commonResult.getMessage());
			return;
		}
		log.info("------------>订单微服务开始调用【库存】结束");
		
		log.info("------------>订单微服务开始调用【账户】，做扣钱");
		accountService.decrease(order.getUserId(), order.getMoney());
		log.info("------------>订单微服务开始调用【账户】结束");
		
		log.info("------------>修改订单状态开始");
		orderDao.update(order.getUserId(), 0);
		log.info("------------>修改订单状态结束");
		if(order.getCount()==20) {
			try {
				TimeUnit.SECONDS.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		log.info("------------>下订单结束");
	}
	
}
