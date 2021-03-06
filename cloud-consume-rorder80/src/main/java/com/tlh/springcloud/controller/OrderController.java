package com.tlh.springcloud.controller;

import com.tlh.springcloud.entities.CommonResult;
import com.tlh.springcloud.entities.Payment;
import com.tlh.springcloud.lb.LoadBalanced;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    //    private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private LoadBalanced loadBalanced;

    @Autowired
    private DiscoveryClient discoveryClient;


    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> ServiceInstanceList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance serviceInstance = loadBalanced.serviceInstance(ServiceInstanceList);
        URI uri = serviceInstance.getUri();
        String url=uri+"/payment/lb";
        log.info("url:"+url);
        return restTemplate.getForObject(url, String.class);
    }


}
