package com.even;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import java.time.Duration;

@SpringBootTest
class SpringBootWebfluxWebclientApplicationTests {

	@Test
	void contextLoads()  {
		Mono<String> stubMonoWithADelay = Mono.just("Hello");

		stubMonoWithADelay.subscribe(System.out::println);


	}

}
