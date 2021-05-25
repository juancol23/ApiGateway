package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	@Value("${test.uri}")
	private String uri;

	@Value("${test.uri2}")
	private String uri2;

	@Value("${test.uri3}")
	private String uri3;

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}


	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder){
		return builder.routes()
				.route(r ->r.path("/api/**").uri(uri))
				.route(r ->r.path("/api/**").uri(uri2))
				.route(r ->r.path("/api/**").uri(uri3)).build();
	}



}
