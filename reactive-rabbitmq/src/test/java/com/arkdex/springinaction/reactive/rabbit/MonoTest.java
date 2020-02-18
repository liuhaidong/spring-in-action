package com.arkdex.springinaction.reactive.rabbit;

import org.junit.Test;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Optional;

public class MonoTest {
    //@Test
    public void testException(){
        Mono.defer(()->{
            return Mono.error(new RuntimeException());
        }).subscribe();
    }

    //@Test
    public void testCallable(){
        Mono.fromCallable(() -> "9999").subscribe(System.out::println);
    }

   // @Test
    public void testFuture(){
     //   Mono.fromCompletionStage(future).block();
    }

    @Test
    public void testDelay(){
        Mono.delay(Duration.ofSeconds(3)).doOnNext(System.out::println).block();
    }

    @Test
    public void testCreate(){
        Mono.fromSupplier(() -> "Hello").subscribe(System.out::println);
        Mono.justOrEmpty(Optional.of("Hello")).subscribe(System.out::println);
        Mono.create(sink -> sink.success("Hello")).subscribe(System.out::println);
    }
}
