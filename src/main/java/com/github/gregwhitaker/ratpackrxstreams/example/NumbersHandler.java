package com.github.gregwhitaker.ratpackrxstreams.example;

import com.github.gregwhitaker.ratpackrxstreams.example.service.NumberService;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import ratpack.handling.Context;
import ratpack.handling.Handler;

@Singleton
public class NumbersHandler implements Handler {

    private final NumberService numberService;

    @Inject
    public NumbersHandler(NumberService numberService) {
        this.numberService = numberService;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        numberService.next().subscribe(val -> ctx.getResponse().send(Integer.toString(val)));
    }
}
