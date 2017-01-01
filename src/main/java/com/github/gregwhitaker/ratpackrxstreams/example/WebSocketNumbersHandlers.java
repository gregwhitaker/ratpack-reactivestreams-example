package com.github.gregwhitaker.ratpackrxstreams.example;

import com.github.gregwhitaker.ratpackrxstreams.example.service.NumberService;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import ratpack.handling.Context;
import ratpack.handling.Handler;

@Singleton
public class WebSocketNumbersHandlers implements Handler {

    private final NumberService numberService;

    @Inject
    public WebSocketNumbersHandlers(NumberService numberService) {
        this.numberService = numberService;
    }

    @Override
    public void handle(Context ctx) throws Exception {

    }
}