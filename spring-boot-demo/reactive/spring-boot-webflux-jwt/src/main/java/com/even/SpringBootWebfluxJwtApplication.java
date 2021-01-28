package com.even;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class SpringBootWebfluxJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebfluxJwtApplication.class, args);
    }

}
