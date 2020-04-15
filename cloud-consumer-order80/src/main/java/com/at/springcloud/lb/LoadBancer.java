package com.at.springcloud.lb;

import java.util.List;

import org.springframework.cloud.client.ServiceInstance;

public interface LoadBancer {
	public ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
