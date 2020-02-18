package com.arkdex.springinaction.reactive.rabbit;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class FluxTest {
    //@Test
    public void testRange(){
        Flux.range(1, 10)
                .timeout(Flux.never(), v -> Flux.never())
                .subscribe(System.out::println);
    }

    //@Test
    public void testDuration(){
        Flux.interval(Duration.ofSeconds(2)).doOnNext(System.out::println).blockLast();
    }

   // @Test
    public void testGenerate(){
        Flux.generate(sink -> {
            sink.next("Hello");
            sink.complete();
        }).subscribe(System.out::println);
    }

    //@Test
    public  void testList(){
        final Random random = new Random();
        Flux.generate(ArrayList::new, (list, sink) -> {
            int value = random.nextInt(100);
            list.add(value);
            sink.next(value);
            if (list.size() == 10) {
                sink.complete();
            }
            return list;
        }).subscribe(System.out::println);
    }

    //@Test
    public void testCreate(){
        Flux.create(sink -> {
            for (int i = 0; i < 10; i++) {
                sink.next(i);
            }
            sink.complete();
        }).subscribe(System.out::println);
    }

    //@Test
    public void testMap(){
        Flux.just(1, 2, 3, 4)
                .log()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i * 2;
                })
                .subscribe(e -> System.out.println(e));
    }

    @Test
    public void testFlatMap() throws InterruptedException {
        Flux.just(1,2,3,4)
                .log()
                .flatMap(e -> {
                    return Flux.just(e*2).delayElements(Duration.ofSeconds(1));
                })
                .subscribe(e -> System.out.println(e));
        TimeUnit.SECONDS.sleep(10);
    }
}
