package com.github.gregwhitaker.ratpackrxstreams.example;

import com.github.gregwhitaker.ratpackrxstreams.example.service.NumberService;
import com.github.gregwhitaker.ratpackrxstreams.example.service.RandomNumberService;
import com.google.inject.AbstractModule;

public class NumbersModule extends AbstractModule {

    @SuppressWarnings("PointlessBinding")
    @Override
    protected void configure() {
        bind(NumberService.class).to(RandomNumberService.class);
        bind(NumbersHandler.class);
    }
}
