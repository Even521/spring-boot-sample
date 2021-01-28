package com.even.auth.service;

import com.even.auth.dto.JwtTokensDto;
import com.even.auth.exception.exceptions.CantSignInException;
import com.even.auth.exception.exceptions.InvalidTokenException;
import com.even.auth.exception.exceptions.RefreshTokenExpiredException;
import com.even.auth.model.UserStatus;
import com.even.security.JwtTokenProvider;
import com.even.user.UserRepository;
import com.even.user.Users;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * @author even
 * @date 2021/1/28 0028 下午 15:14
 * @describe
 */
@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
   // private final PasswordEncoder passwordEncoder;

    //@Transactional
    public Mono<JwtTokensDto> signIn(String userId, String password) {
        return Mono.fromCallable(() ->
                userRepository.findByUserIdAndState(userId, UserStatus.NORMAL))
                .subscribeOn(Schedulers.elastic())
                .switchIfEmpty(Mono.error(CantSignInException::new))
                .map(user -> validatePasswordAndUpdateRefreshToken(password, user))
                .map(user ->
                        new JwtTokensDto(
                                jwtTokenProvider.createAccessToken(userId, user.getRoles()),
                                user.getRefreshToken()
                        )
                );
    }

    private Users validatePasswordAndUpdateRefreshToken(String password, Users user) {
        //if (!passwordEncoder.matches(password, user.getPassword())){
        //    throw new CantSignInException();}
            if(!password.equals(password)){
                throw new CantSignInException();
            }

        user.updateRefreshToken(jwtTokenProvider.createRefreshToken(user.getUserId(), user.getRoles()));
        return user;
    }

    // @Transactional
    public Mono<Void> signUp(String userId, String password, String email) {
        return Mono.fromCallable(() -> userRepository.save(new Users(userId, password, email)))
                .subscribeOn(Schedulers.elastic())
                .then();
    }

    // @Transactional
    public Mono<String> refreshAccessToken(String accessToken, String refreshToken) {
        return Mono.just(validateTokens(accessToken, refreshToken))
                .onErrorStop()
                .flatMap(requestUserId ->
                        Mono.fromCallable(() -> userRepository.findByUserIdAndState(requestUserId, UserStatus.NORMAL))
                                .subscribeOn(Schedulers.elastic())
                                .switchIfEmpty(Mono.error(CantSignInException::new))
                )
                .map(account -> jwtTokenProvider.createAccessToken(account.getUserId(), account.getRoles()));
    }

    private String validateTokens(String accessToken, String refreshToken) {
        String accessTokenUserId = "";
        String refreshTokenUserId;
        try {
            accessTokenUserId = jwtTokenProvider.getUserId(jwtTokenProvider.getClaimsFromToken(accessToken));
        } catch (ExpiredJwtException ignore) {
        }
        try {
            refreshTokenUserId = jwtTokenProvider.getUserId(jwtTokenProvider.getClaimsFromToken(refreshToken));
        } catch (ExpiredJwtException e) {
            throw new RefreshTokenExpiredException();
        }

        if (!accessTokenUserId.equals(refreshTokenUserId)){
            throw new InvalidTokenException();}

        return accessTokenUserId;
    }
}
