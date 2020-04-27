package com.at.springcloud.alibaba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.at.springcloud.alibaba.dao.StorageDao;
import com.at.springcloud.alibaba.domain.CommonResult;
import com.at.springcloud.alibaba.domain.Storage;
import com.at.springcloud.alibaba.service.StorageService;

@Service
public class StorageServiceImpl implements StorageService {
	@Autowired
	private StorageDao storageDao;
	
	@Override
	public CommonResult<Object> decrease(Long productId, Integer count) {
		Storage storage = storageDao.getProduct(productId);
		if(storage.getResidue()<count) {
			return new CommonResult<Object>(555,"库存不足。。。。。。。。。");
		}
		//int a = 10/0;
		storageDao.update(storage.getUsed()+count, storage.getResidue()-count, productId);
		return new CommonResult<Object>(200,"库存扣除成功",storage);
	}

}
