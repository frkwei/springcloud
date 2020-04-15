package com.at.springcloud.lb.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import com.at.springcloud.lb.LoadBancer;

@Component
public class MyLoadBancer implements LoadBancer {
	private AtomicInteger atomicInteger= new AtomicInteger(0);
	
	public final int getAndIncrement() {
		int current = atomicInteger.get();
		int next = current >=Integer.MAX_VALUE?0:(current+1);
		while(true){
			if(atomicInteger.compareAndSet(current, next)) {
				return atomicInteger.get();
			}
			current = atomicInteger.get();
			next = current >=Integer.MAX_VALUE?0:(current+1);
		}
	}
	
	@Override
	public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
		int index = getAndIncrement()%serviceInstances.size();
		return serviceInstances.get(index);
	}

}
