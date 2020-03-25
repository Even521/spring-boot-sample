package com.even.client;

import com.even.data.Message;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

/**
 * @author even
 * @date 2020/3/25 0025
 * @describe
 */
@ShellComponent
@Log4j2
public class RSocketShellClient {

    private final RSocketRequester rsocketRequester;
    private static final String CLIENT = "Client";
    private static final String REQUEST = "Request";
    private static final String FIRE_AND_FORGET = "Fire-And-Forget";
    private static final String STREAM = "Stream";
    private static final String CHANNEL = "Channel";
    private static Disposable disposable;

    @Autowired
    public RSocketShellClient(RSocketRequester.Builder rsocketRequesterBuilder) {
        this.rsocketRequester = rsocketRequesterBuilder
                .connectTcp("localhost", 7000).block();
    }

    @ShellMethod("Send one request. One response will be printed.")
    public void requestResponse() throws InterruptedException {
        log.info("\nSending one request. Waiting for one response...");
        Message message = this.rsocketRequester
                .route("request-response")
                .data(new Message(CLIENT, REQUEST))
                .retrieveMono(Message.class)
                .block();
        log.info("\nResponse was: {}", message);
    }

    @ShellMethod("Send one request. No response will be returned.")
    public void fireAndForget() throws InterruptedException {
        log.info("\nFire-And-Forget. Sending one request. Expect no response (check server console log)...");
        this.rsocketRequester
                .route("fire-and-forget")
                .data(new Message(CLIENT, FIRE_AND_FORGET))
                .send()
                .block();
    }

    @ShellMethod("Send one request. Many responses (stream) will be printed.")
    public void stream() {
        log.info("\nRequest-Stream. Sending one request. Waiting for responses (Type 's' to stop)...");
        disposable = this.rsocketRequester
                .route("stream")
                .data(new Message(CLIENT, STREAM))
                .retrieveFlux(Message.class)
                .subscribe(er -> log.info("New Response: {} (Type 's' to stop.)", er));
    }

    @ShellMethod("Stream ten requests. Ten responses (stream) will be printed.")
    public void channel(){
        log.info("\nChannel. Sending ten requests. Waiting for ten responses...");
        disposable = this.rsocketRequester
                .route("channel")
                .data(Flux.range(0,10).map(integer -> new Message(CLIENT, CHANNEL, integer)), Message.class)
                .retrieveFlux(Message.class)
                .subscribe(er -> log.info("Response received: {} (Type 's' to stop.)", er));
    }

    @ShellMethod("Stop streaming messages from the server.")
    public void s(){
        if(null != disposable){
            disposable.dispose();
        }
    }
}
