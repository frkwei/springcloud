package com.at.springcloud.alibaba.dao;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountDao {
	public void update(@Param("userId")Long userId,@Param("money")BigDecimal count);
}
