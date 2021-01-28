package com.even.auth.controller;

import com.even.auth.dto.JwtTokensDto;
import com.even.auth.request.RefreshAccessTokenRequest;
import com.even.auth.request.SignInRequest;
import com.even.auth.request.SignUpRequest;
import com.even.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * @author even
 * @date 2021/1/28 0028 下午 15:13
 * @describe
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.OK)
    Mono<JwtTokensDto> signIn(@RequestBody SignInRequest signInRequest) {
        return authService.signIn(signInRequest.getUserId(), signInRequest.getPassword());
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.OK)
    Mono<Void> signUp(@RequestBody SignUpRequest signUpRequest) {
        return authService.signUp(
                signUpRequest.getUserId(),
                signUpRequest.getPassword(),
                signUpRequest.getEmail()
        );
    }

    @PostMapping("/refresh")
    @ResponseStatus(HttpStatus.OK)
    Mono<String> refreshAccessToken(@RequestBody RefreshAccessTokenRequest refreshAccessTokenRequest) {
        return authService.refreshAccessToken(
                refreshAccessTokenRequest.getAccessToken(),
                refreshAccessTokenRequest.getRefreshToken()
        );

    }
}
