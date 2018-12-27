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
 * 路由断言工厂会取一个UTC的时间格式参数，会根据请求进来的当前时间
 * after，before，between
 */
public class TimeRoute {
    //@Bean
    public RouteLocator after(RouteLocatorBuilder builder){
        ZonedDateTime zonedDateTime= LocalDateTime.now().minusHours(1).atZone(ZoneId.systemDefault());

        return builder.routes()
                .route(
                        "after_route",r->r.after(zonedDateTime).uri("http://www.baidu.com")
                )
                .build();
    }
}
