package com.example.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by Administrator on 2018/12/27 0027.
 *
 * @author even
 * Cookie路由会根据key value判断工厂配置的cookie是否一致，一致成功否则不成功
 */
public class CookieRoute {
    //@Bean
    public RouteLocator cookie(RouteLocatorBuilder builder){
        return builder.routes()
                .route(
                     "cookie_route",r->r.cookie("chocolate","ch.p")
                        .uri("http://www.baidu.com")
                )
                .build();
    }
}
