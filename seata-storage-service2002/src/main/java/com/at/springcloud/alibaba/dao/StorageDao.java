package com.at.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.at.springcloud.alibaba.domain.Storage;

@Mapper
public interface StorageDao {
	//1  新建订单
	public Storage getProduct(@Param("productId")Long productId);
	
	public void update(@Param("count")Integer count,@Param("residue")Integer residue,@Param("productId")Long productId);
}
