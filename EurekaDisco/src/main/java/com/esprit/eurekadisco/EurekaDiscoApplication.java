package com.esprit.eurekadisco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDiscoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaDiscoApplication.class, args);
    }

}
