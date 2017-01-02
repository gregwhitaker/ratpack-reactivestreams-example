package com.github.gregwhitaker.ratpackrxstreams.example.service;

import rx.Observable;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Generates an observable sequence of random numbers between 1 and 100.
 */
public class RandomNumberService implements NumberService {
    private static final Random RAND = new Random(System.currentTimeMillis());

    @Override
    public Observable<Integer> next(int cnt) {
        return Observable.range(1, cnt)
                .delay(1, TimeUnit.SECONDS)
                .map(i -> RAND.nextInt(100 - 1 + 1) + 1);
    }
}
