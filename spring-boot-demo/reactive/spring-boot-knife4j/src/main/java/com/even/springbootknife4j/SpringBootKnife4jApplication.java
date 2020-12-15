package com.even.springbootknife4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class SpringBootKnife4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKnife4jApplication.class, args);
    }

}
