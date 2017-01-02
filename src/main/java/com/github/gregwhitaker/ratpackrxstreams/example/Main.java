package com.github.gregwhitaker.ratpackrxstreams.example;

import ratpack.guice.Guice;
import ratpack.rx.RxRatpack;
import ratpack.server.BaseDir;
import ratpack.server.RatpackServer;

/**
 * Example application that generates a random number every second and sends it to
 * subscribed clients via reactivestreams over websockets.
 */
public class Main {

    /**
     * Main entry-point of the application.
     */
    public static void main(String... args) throws Exception {
        RxRatpack.initialize();

        RatpackServer.start(s -> s
                .serverConfig(c -> c.baseDir(BaseDir.find()))
                .registry(Guice.registry(b -> b.module(NumbersModule.class)))
                .handlers(chain -> chain
                        .get("numbers", WebSocketNumbersHandlers.class)
                        .files(f -> f
                                .dir("public").indexFiles("index.html"))));
    }
}
