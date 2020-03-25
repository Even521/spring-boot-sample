package com.even.config;

import io.rsocket.RSocketFactory;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.rsocket.server.ServerRSocketFactoryProcessor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author even
 * @date 2020/3/25 0025
 * @describe
 */
@Profile("resumption")
@Component
@Log4j2
public class RSocketServerResumptionConfig implements ServerRSocketFactoryProcessor {
    @Override
    public RSocketFactory.ServerRSocketFactory process(RSocketFactory.ServerRSocketFactory factory) {
        log.info("Adding RSocket Server 'Resumption' Feature.");
        // By default duration=120s and store=InMemory and timeout=10s
        return factory.resume();
    }
}
