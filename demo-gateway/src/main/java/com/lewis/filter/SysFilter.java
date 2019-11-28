package com.lewis.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class SysFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //添加转发服务的头部信息
        exchange.getRequest().mutate().header("FROM-GATEWAY-REQUEST","FROM-GATEWAY-REQUEST");
        return chain.filter(exchange);

    }
}
