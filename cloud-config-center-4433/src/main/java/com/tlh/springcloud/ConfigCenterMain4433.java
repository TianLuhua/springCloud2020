package com.tlh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain4433 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain4433.class, args);
    }
}
