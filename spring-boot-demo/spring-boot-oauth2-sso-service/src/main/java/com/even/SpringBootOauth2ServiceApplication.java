package com.even;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication

public class SpringBootOauth2ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootOauth2ServiceApplication.class, args);
    }

}

