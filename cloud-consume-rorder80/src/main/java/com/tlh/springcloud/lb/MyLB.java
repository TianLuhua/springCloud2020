package com.tlh.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class MyLB implements LoadBalanced {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        for (; ; ) {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current+1;
            if (atomicInteger.compareAndSet(current, next))
                break;
        }
        return next;
    }

    @Override
    public ServiceInstance serviceInstance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        log.info("index:" + index);
        return serviceInstances.get(index);
    }

}
