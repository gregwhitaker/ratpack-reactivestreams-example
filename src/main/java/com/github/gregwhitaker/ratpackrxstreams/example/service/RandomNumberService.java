/*
 * Copyright 2017 Greg Whitaker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
