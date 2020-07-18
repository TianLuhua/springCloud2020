package com.tlh.springcloud.controller;

import com.tlh.springcloud.entities.CommonResult;
import com.tlh.springcloud.entities.Payment;
import com.tlh.springcloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class PaymentContorller {

    @Resource
    private IPaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String servicePort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功!servicePort:"+servicePort);
        } else {
            return new CommonResult(400, "插入数据库失败!");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        if (result != null) {
            return new CommonResult(200, "查询ok!servicePort:"+servicePort, result);
        } else {
            return new CommonResult(400, "没有对应记录 id：" + id);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        Map<String,List<ServiceInstance>> serviceMap=new HashMap();
        return  discoveryClient.getServices().stream().map(item -> {
            serviceMap.put(item, discoveryClient.getInstances(item));
            return serviceMap;
        });
    }

}
