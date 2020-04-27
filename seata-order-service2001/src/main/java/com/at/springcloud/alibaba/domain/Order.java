package com.at.springcloud.alibaba.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	private Long id;
	
	private Long userId;
	
	private Long productId;
	
	private Integer count;
	
	private BigDecimal money;
	
	private Integer status; //0创建中，1已完结

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", productId=" + productId + ", count=" + count + ", money="
				+ money + ", status=" + status + "]";
	}
}
