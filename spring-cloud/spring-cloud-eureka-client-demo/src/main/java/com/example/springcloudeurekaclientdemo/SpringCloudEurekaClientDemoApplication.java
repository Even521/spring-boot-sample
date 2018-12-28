package com.example.springcloudeurekaclientdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudEurekaClientDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaClientDemoApplication.class, args);
    }

}

