package com.arkdex.springinaction.disruptorqueue;

import com.arkdex.springinaction.disruptorqueue.ticker.*;
import com.arkdex.springinaction.disruptorqueue.workhandler.TickerConsumer;
import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ThreadFactory;

public class TickerDisruptorTest {
    private Disruptor<Ticker> disruptor;
    private WaitStrategy waitStrategy;

    @Before
    public void setUp() throws Exception {
        waitStrategy = new BusySpinWaitStrategy();
    }

    private void createDisruptor(final ProducerType producerType, final EventConsumer eventConsumer) {
        final ThreadFactory threadFactory = DaemonThreadFactory.INSTANCE;
        disruptor = new Disruptor<>(Ticker.EVENT_FACTORY, 32, threadFactory, producerType, waitStrategy);
        disruptor.handleEventsWith(eventConsumer.getEventHandler());
    }

    private void createDisruptorHandlerPool(final ProducerType producerType, final TickerConsumer[] consumers) {
        final ThreadFactory threadFactory = DaemonThreadFactory.INSTANCE;
        disruptor = new Disruptor<>(Ticker.EVENT_FACTORY, 32, threadFactory, producerType, waitStrategy);
        disruptor.handleEventsWithWorkerPool(consumers);
    }

    private void startProducing(final RingBuffer<Ticker> ringBuffer, final int count, final EventProducer eventProducer) {
        eventProducer.startProducing(ringBuffer, count);
    }

   // @Test
    public void whenMultipleProducerSingleConsumer_thenOutputInFifoOrder() {
        final EventConsumer eventConsumer = new SingleEventPrintConsumer();
        final EventProducer eventProducer = new DelayedMultiEventProducer();
        createDisruptor(ProducerType.MULTI, eventConsumer);
        final RingBuffer<Ticker> ringBuffer = disruptor.start();

        startProducing(ringBuffer, 32, eventProducer);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        disruptor.halt();
       disruptor.shutdown();
    }

    //@Test
    public void whenSingleProducerSingleConsumer_thenOutputInFifoOrder() {
        final EventConsumer eventConsumer = new SingleEventPrintConsumer();
        final EventProducer eventProducer = new SingleTickerProducer();
        createDisruptor(ProducerType.SINGLE, eventConsumer);
        final RingBuffer<Ticker> ringBuffer = disruptor.start();

        startProducing(ringBuffer, 32, eventProducer);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        disruptor.halt();
        disruptor.shutdown();
    }


    //@Test
    public void whenSingleProducerMultipleConsumer_thenOutputInFifoOrder() {
        final EventConsumer eventConsumer = new MultiEventPrintConsumer();
        final EventProducer eventProducer = new SingleTickerProducer();
        createDisruptor(ProducerType.SINGLE, eventConsumer);
        final RingBuffer<Ticker> ringBuffer = disruptor.start();

        startProducing(ringBuffer, 32, eventProducer);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        disruptor.halt();
        disruptor.shutdown();
    }

   // @Test
    public void whenMultipleProducerMultipleConsumer_thenOutputInFifoOrder() {
        final EventConsumer eventConsumer = new MultiEventPrintConsumer();
        final EventProducer eventProducer = new DelayedMultiEventProducer();
        createDisruptor(ProducerType.MULTI, eventConsumer);
        final RingBuffer<Ticker> ringBuffer = disruptor.start();

        startProducing(ringBuffer, 32, eventProducer);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        disruptor.halt();
        disruptor.shutdown();
    }

    @Test
    public void testWorkHandler(){
        TickerConsumer[] consumers = new TickerConsumer[10];
        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new TickerConsumer();
        }
        createDisruptorHandlerPool(ProducerType.MULTI,consumers);
        final RingBuffer<Ticker> ringBuffer = disruptor.start();
        final EventProducer eventProducer = new DelayedMultiEventProducer();
        startProducing(ringBuffer, 32, eventProducer);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        disruptor.halt();
        disruptor.shutdown();
    }
}
