package com.at.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.at.springcloud.alibaba.domain.Order;

@Mapper
public interface OrderDao {
	//1  新建订单
	public void createOrder(Order order);
	
	//2  更改订单，状态从0改成1
	public void update(@Param("userId")Long userId,@Param("status")Integer status);
}
