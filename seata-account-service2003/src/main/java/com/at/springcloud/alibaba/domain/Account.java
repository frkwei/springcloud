package com.at.springcloud.alibaba.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	private Long id;
	
	private Long productId;
	
	private BigDecimal total;
	
	private BigDecimal used;
	
	private BigDecimal residue;

	@Override
	public String toString() {
		return "Storage [id=" + id + ", productId=" + productId + ", total=" + total + ", used=" + used + ", residue="
				+ residue + "]";
	} 

	
}
