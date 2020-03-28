package com.arkdex.springinaction.disruptorqueue.ticker;

import com.arkdex.springinaction.disruptorqueue.Ticker;
import com.lmax.disruptor.RingBuffer;

import java.time.ZonedDateTime;
import java.util.Date;

public class SingleTickerProducer implements EventProducer {

    @Override
    public void startProducing(RingBuffer<Ticker> ringBuffer, int count) {
        final Runnable producer = () -> produce(ringBuffer, count);
        new Thread(producer).start();
    }

    private void produce(final RingBuffer<Ticker> ringBuffer, final int count) {
        for (int i = 0; i < count; i++) {
            final long seq = ringBuffer.next();
            final Ticker Ticker = ringBuffer.get(seq);
            Ticker.setDate(System.nanoTime());
            ringBuffer.publish(seq);
        }
    }

}
