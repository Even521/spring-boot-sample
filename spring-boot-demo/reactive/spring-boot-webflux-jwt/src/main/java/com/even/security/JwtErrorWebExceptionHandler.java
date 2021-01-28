package com.even.security;

import com.even.common.repose.ErrorResponse;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author even
 * @date 2021/1/28 0028 下午 14:52
 * @describe
 */
public class JwtErrorWebExceptionHandler extends AbstractErrorWebExceptionHandler {

    public JwtErrorWebExceptionHandler(ErrorAttributes errorAttributes, WebProperties.Resources resources, ApplicationContext applicationContext, ServerCodecConfigurer configurer) {
        super(errorAttributes, resources, applicationContext);
        this.setMessageWriters(configurer.getWriters());
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(
                RequestPredicates.all(), this::renderErrorResponse);
    }

    private Mono<ServerResponse> renderErrorResponse(
            ServerRequest request) {

        Map<String, Object> errorPropertiesMap = getErrorAttributes(request,
                ErrorAttributeOptions.of(ErrorAttributeOptions.Include.EXCEPTION));
        ErrorResponse errorResponse;
        switch ((String) errorPropertiesMap.get("exception")) {
            case "io.jsonwebtoken.security.SignatureException":
                errorResponse = new ErrorResponse(HttpStatus.UNAUTHORIZED, "0001", "Invalid Token");
                break;
            case "io.jsonwebtoken.MalformedJwtException":
                errorResponse = new ErrorResponse(HttpStatus.UNAUTHORIZED, "0002", "Corrupted Token");
                break;
            case "io.jsonwebtoken.ExpiredJwtException":
                errorResponse = new ErrorResponse(HttpStatus.UNAUTHORIZED, "0003", "Expired Token");
                break;
            default:
                errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "0000", "Unknown Auth Error");
        }

        return ServerResponse.status(errorResponse.getStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(errorResponse));
    }
}
