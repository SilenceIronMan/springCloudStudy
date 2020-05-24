package com.ysy.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @anthor silenceYin
 * @date 2020/5/24 - 19:02
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customerRouteLocater(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_ysy", r -> r.path("/guonei").uri("http://news.baidu.com"));
        return routes.build();
    }
}
