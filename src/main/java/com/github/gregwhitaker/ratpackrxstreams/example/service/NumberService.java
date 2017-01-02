package com.github.gregwhitaker.ratpackrxstreams.example.service;

import rx.Observable;

/**
 * Service that generates numbers.
 */
public interface NumberService {

    /**
     * Get the next number.
     *
     * @param cnt total numbers to return
     * @return next number
     */
    Observable<Integer> next(int cnt);
}
