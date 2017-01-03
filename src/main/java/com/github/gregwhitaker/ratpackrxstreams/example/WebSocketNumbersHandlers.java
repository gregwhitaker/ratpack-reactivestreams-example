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
