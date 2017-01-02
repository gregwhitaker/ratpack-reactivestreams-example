package com.github.gregwhitaker.ratpackrxstreams.example;

import com.github.gregwhitaker.ratpackrxstreams.example.service.NumberService;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.reactivestreams.Publisher;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.websocket.WebSockets;
import rx.RxReactiveStreams;

@Singleton
public class WebSocketNumbersHandlers implements Handler {

    private final NumberService numberService;

    @Inject
    public WebSocketNumbersHandlers(NumberService numberService) {
        this.numberService = numberService;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        int cnt = Integer.valueOf(ctx.getRequest().getQueryParams().getOrDefault("cnt", "10"));

        Publisher<String> numbers = RxReactiveStreams
                .toPublisher(numberService.next(cnt)
                        .map(num -> Integer.toString(num)));

        WebSockets.websocketBroadcast(ctx, numbers);
    }
}
