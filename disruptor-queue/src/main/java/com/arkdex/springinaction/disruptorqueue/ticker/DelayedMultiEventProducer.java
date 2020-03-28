package com.arkdex.springinaction.disruptorqueue.ticker;

import com.arkdex.springinaction.disruptorqueue.Ticker;
import com.lmax.disruptor.RingBuffer;

import java.time.ZonedDateTime;

public class DelayedMultiEventProducer implements EventProducer {

    @Override
    public void startProducing(final RingBuffer<Ticker> ringBuffer, final int count) {
        final Runnable simpleProducer = () -> produce(ringBuffer, count, false,0);
        final Runnable delayedProducer = () -> produce(ringBuffer, count, true,1);
        new Thread(simpleProducer).start();
        new Thread(delayedProducer).start();
    }

    private void produce(final RingBuffer<Ticker> ringBuffer, final int count, final boolean addDelay,final int sourceId) {
        try{
        for (int i = 0; i < count; i++) {
            final long seq = ringBuffer.next();
            final Ticker valueEvent = ringBuffer.get(seq);
            valueEvent.setSourceId(sourceId);
            valueEvent.setDate(System.nanoTime());
            ringBuffer.publish(seq);
            if (addDelay) {
                addDelay();
            }
        }}catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void addDelay() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException interruptedException) {
            // No-Op lets swallow it
        }
    }
}
