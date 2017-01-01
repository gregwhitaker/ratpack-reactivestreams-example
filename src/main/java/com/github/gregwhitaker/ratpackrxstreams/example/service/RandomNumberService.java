package com.github.gregwhitaker.ratpackrxstreams.example.service;

import java.util.Random;

/**
 * Generates a random number between 1 and 100.
 */
public class RandomNumberService implements NumberService {
    private static final Random RAND = new Random(System.currentTimeMillis());

    @Override
    public int next() {
        return RAND.nextInt(100 - 1 + 1) + 1;
    }
}
