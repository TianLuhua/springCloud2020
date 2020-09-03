package com.tlh.cloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(scanBasePackages = {"com.tlh"}, exclude = DataSourceAutoConfiguration.class)
public class SeateStorageMain8502 {
    public static void main(String[] args) {
        SpringApplication.run(SeateStorageMain8502.class, args);

    }
}
