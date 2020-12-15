package com.even;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * 新增注解openApi
 */
@SpringBootApplication
@EnableOpenApi
public class SpringBootWebfluxSwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebfluxSwaggerApplication.class, args);
    }

}
