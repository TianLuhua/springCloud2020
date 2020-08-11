package com.tlh.alibabacloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class Nacos11001OrderController {

    private static  final  String SERVICE_URL="http://cloud-alibaba-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/nacos/payment/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        return restTemplate.getForObject(SERVICE_URL+"/nacos/payment/"+id,String.class);
    }
}
