package com.even;

import com.even.entity.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@SpringBootApplication
public class SpringBootWebfluxRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebfluxRedisApplication.class, args);
	}
    /**
     * demo 控制层
     * @return
     * @ahtor even
     * @since
     */
	@RestController
	@RequiredArgsConstructor
	class DemoController{

        private final ReactiveRedisTemplate<String,UserInfo> redisTemplate;
        private final static String DEMO_KEY="demo:user:";



		/**
         * 保存方法
         * @return
         * @ahtor even
         * @since
         */
		@GetMapping("/save")
		public Mono<UserInfo> stringMono(){
			//todo 为方便就不传参
			UserInfo userInfo=new UserInfo(1,"even", LocalDateTime.now());
			redisTemplate.opsForValue().set(DEMO_KEY+userInfo.getId(),userInfo);
			return Mono.create(monoSink->monoSink.success(userInfo));
		}
		@GetMapping("/list")
		public Mono<UserInfo> getList(){
			return redisTemplate.opsForValue().get(DEMO_KEY+1);
		}


	}
}
