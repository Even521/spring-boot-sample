package com.even;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class SpringBootWebfluxEnvironmentConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebfluxEnvironmentConfigurationApplication.class, args);
	}

    @RestController
   	class DemoController{

		@Value("${environment}")
		private String environment;

		@GetMapping("/demo")
		public Mono<String> stringMono(){
			return Mono.just(environment);
		}


	}

}
