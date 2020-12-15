package com.even.router;

import com.even.handler.AppleHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author even
 * @date 2019/8/1 0001
 * @describe
 */
@Configuration
public class AppleRouter {
    @Bean
    public RouterFunction<ServerResponse> routeApple(AppleHandler appleHandler){
        return RouterFunctions.route(
                RequestPredicates.GET("/hello")
                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                appleHandler::helloApple
        );
    }
}
