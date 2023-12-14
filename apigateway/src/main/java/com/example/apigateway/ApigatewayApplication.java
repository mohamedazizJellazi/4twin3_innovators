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
						.uri("http://universite:8082/"))  // Update this line
				.route("microbloc", r->r.path("/bloc/**")
						.uri("http://bloc:8083/"))  // Update this line
				.route("microchambre", r->r.path("/chambre/**")
						.uri("http://chambre:8084/"))  // Update this line
				.route("microetudiant", r->r.path("/etudiant/**","/reservation/**")
						.uri("http://etudiant:8085/"))  // Update this line
				.route("microfoyer", r->r.path("/foyer/**")
						.uri("http://foyer:8081/"))  // Update this line
				.build();
	}

}
