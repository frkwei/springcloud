package com.at.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
	private Long id;
	
	private Long productId;
	
	private Integer total;
	
	private Integer used;
	
	private Integer residue;

	@Override
	public String toString() {
		return "Storage [id=" + id + ", productId=" + productId + ", total=" + total + ", used=" + used + ", residue="
				+ residue + "]";
	} 

	
}
