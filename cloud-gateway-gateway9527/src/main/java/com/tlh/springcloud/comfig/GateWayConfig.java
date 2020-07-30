package com.tlh.springcloud.comfig;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r->r.path("/payment/get/**").uri("http://localhost:8001"))
                .route(r->r.path("/payment/lb/**").uri("http://localhost:8002"))
                .build();
    }
}
