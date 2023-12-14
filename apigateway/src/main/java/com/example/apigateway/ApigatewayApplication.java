package com.example.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatewayApplication.class, args);
	}
	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("microuniversite", r->r.path("/universite/**")
						.uri("http://localhost:8082/"))
				.route("microbloc", r->r.path("/bloc/**")
						.uri("http://localhost:8083/"))
				.route("microchambre", r->r.path("/chambre/**")
						.uri("http://localhost:8084/"))
				.route("microetudiant", r->r.path("/etudiant/**","/reservation/**")
						.uri("http://localhost:8085/"))
				.route("microfoyer", r->r.path("/foyer/**")
						.uri("http://localhost:8081/"))
				.build();
	}
}
