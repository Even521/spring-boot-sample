package com.even.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author even
 * @date 2019/8/1 0001
 * @describe
 */
@Component
public class AppleHandler {
    /**
     * hello
     * @param request
     * @return
     */
    public Mono<ServerResponse> helloApple(ServerRequest request){
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(
                BodyInserters.fromObject("hello apple")
        );
    }
}
