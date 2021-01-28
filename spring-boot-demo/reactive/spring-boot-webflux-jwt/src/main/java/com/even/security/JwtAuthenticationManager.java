package com.even.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author even
 * @date 2021/1/28 0028 下午 14:42
 * @describe
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationManager implements ReactiveAuthenticationManager {
    private final JwtTokenProvider jwtTokenProvider;
    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        return Mono.just(authentication)
                .flatMap(jwtTokenProvider::validateAndGetClaimsFromToken)
                .onErrorStop()
                .flatMap(jwtTokenProvider::getAuthentication);
    }
}
