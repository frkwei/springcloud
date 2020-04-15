package com.at.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {
	//@Bean
	public RouteLocator myRouteLocator(RouteLocatorBuilder builder) {
		RouteLocatorBuilder.Builder routes = builder.routes();
					//id
		routes.route("path-aaa-bbb", r->r.path("/guonei").uri("https://news.baidu.com/guonei"));
		return routes.build();
	}
	
	//@Bean
	public RouteLocator myRouteLocator2(RouteLocatorBuilder builder) {
		RouteLocatorBuilder.Builder routes = builder.routes();
					//id
		routes.route("path-aaa-bbb2", r->r.path("/**").uri("https://news.baidu.com/guonei/guonei"));
		return routes.build();
	}
}
