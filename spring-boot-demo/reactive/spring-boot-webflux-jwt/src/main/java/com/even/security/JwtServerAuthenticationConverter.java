package com.even.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author even
 * @date 2021/1/28 0028 下午 14:49
 * @describe
 */
@Component
public class JwtServerAuthenticationConverter implements ServerAuthenticationConverter {
    @Override
    public Mono<Authentication> convert(ServerWebExchange serverWebExchange) {
        return Mono.justOrEmpty(serverWebExchange)
                .flatMap(s -> Mono.justOrEmpty((s.getRequest().getHeaders().get("Authorization"))))
                .filter(authHeader -> !authHeader.isEmpty())
                .map(token -> new UsernamePasswordAuthenticationToken(token.get(0), token.get(0)));
    }
}
