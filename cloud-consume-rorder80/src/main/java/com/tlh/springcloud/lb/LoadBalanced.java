package com.tlh.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalanced {


    ServiceInstance serviceInstance(List<ServiceInstance> serviceInstances);

}
