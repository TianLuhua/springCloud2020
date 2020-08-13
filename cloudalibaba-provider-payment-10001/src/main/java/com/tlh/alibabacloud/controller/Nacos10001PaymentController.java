package com.tlh.alibabacloud.controller;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class Nacos10001PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/nacos/payment/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        return "Nacos Client !! servicer.port:"+serverPort+",id:"+id;
    }

    @GetMapping("/nacos/payment/config")
    public String getConfigInfo(){
        return configInfo+","+serverPort;
    }
}
