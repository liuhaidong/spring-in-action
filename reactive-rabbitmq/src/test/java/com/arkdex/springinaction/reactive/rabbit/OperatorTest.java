package com.arkdex.springinaction.reactive.rabbit;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class OperatorTest {
    //@Test
    public void testBuffer(){
        Flux.range(1, 100).buffer(20).subscribe(System.out::println);
      //  Flux.intervalMillis(100).bufferMillis(1001).take(2).toStream().forEach(System.out::println);
        Flux.range(1, 10).bufferUntil(i -> i % 2 == 0).subscribe(System.out::println);
        Flux.range(1, 10).bufferWhile(i -> i % 2 == 0).subscribe(System.out::println);
    }

   // @Test
    public void testWindow(){
        //  window 操作符所产生的流中包含的是 UnicastProcessor 类的对象，而 UnicastProcessor 类的 toString 方法输出的就是
        //  UnicastProcessor 字符
        Flux.range(1, 100).window(20).subscribe(System.out::println);
       // Flux.intervalMillis(100).windowMillis(1001).take(2).toStream().forEach(System.out::println);
    }

   // @Test
    public void testZipWith(){

        Flux.just("a", "b")
                .zipWith(Flux.just("c", "d"))
                .subscribe(System.out::println);
        Flux.just("a", "b")
                .zipWith(Flux.just("c", "d"), (s1, s2) -> String.format("%s-%s", s1, s2))
                .subscribe(System.out::println);
    }

    //@Test
    public void testTake(){
        Flux.range(1, 1000).take(10).subscribe(System.out::println);
        System.out.println("-------------------");
        Flux.range(1, 1000).takeLast(10).subscribe(System.out::println);
        System.out.println("-------------------");
        Flux.range(1, 1000).takeWhile(i -> i < 10).subscribe(System.out::println);
        System.out.println("-------------------");
        Flux.range(1, 1000).takeUntil(i -> i == 10).subscribe(System.out::println);
    }

    @Test
    public void testMerge(){
        Flux.merge(Flux.interval(Duration.ofMillis(50)).range(0, 100).take(5), Flux.interval(Duration.ofMillis(100)).range(50, 100).take(5))
                .toStream()
                .forEach(System.out::println);
        Flux.mergeSequential(Flux.range(0, 100).take(5), Flux.range(50, 100).take(5))
                .toStream()
                .forEach(System.out::println);
    }

    //@Test
    public void testI() throws InterruptedException {
        final Flux<Long> source = Flux.interval(Duration.ofMillis(1000))
                .take(10)
                .publish()
                .autoConnect();
        source.subscribe();
        Thread.sleep(1000);
        source
                .toStream()
                .forEach(System.out::println);
    }
}
