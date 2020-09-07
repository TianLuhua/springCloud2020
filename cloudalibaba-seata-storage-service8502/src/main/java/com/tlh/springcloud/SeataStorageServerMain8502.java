package com.tlh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(scanBasePackages = {"com.tlh"}, exclude = DataSourceAutoConfiguration.class)
public class SeataStorageServerMain8501 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageServerMain8501.class, args);
    }
}
