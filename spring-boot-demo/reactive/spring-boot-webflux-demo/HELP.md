# 响应式编程


### 配置pom依赖
```$xslt
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webflux</artifactId>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.projectreactor</groupId>
            <artifactId>reactor-test</artifactId>
            <scope>test</scope>
        </dependency>
```
spring-boot-starter-webflux 依赖，是我们核心需要学习 webflux 的包，里面默认包含了 spring-boot-starter-reactor-netty 、spring 5 webflux 包。也就是说默认是通过 netty 启动的。

###编写一个Handler
```$xslt
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
```
### 编写路由类 Router
新建一个router包
```$xslt
 @Bean
    public RouterFunction<ServerResponse> routeApple(AppleHandler appleHandler){
        return RouterFunctions.route(
                RequestPredicates.GET("/hello")
                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                appleHandler::helloApple
        );
    }
```
为了了解流程添加了路由包，后续会用注解方便开发