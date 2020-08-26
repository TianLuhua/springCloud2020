package com.tlh.alibabacloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "this is test A";
    }

    @GetMapping("/testB")
    public String testB() {
        return "this is test B";
    }


}
