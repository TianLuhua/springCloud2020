package com.tlh.alibabacloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/testhotKey")
    @SentinelResource(value = "testhotKey", blockHandler = "deal_testhotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1, @RequestParam(value = "p2",required = false) String p2) {
        return "this is test hotKey";
    }

    public String deal_testhotKey(String p1, String p2, BlockException e) {
        return "this is deal_testhotKey";
    }
}
