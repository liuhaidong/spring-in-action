package com.arkdex.springinaction.disruptorqueue.ticker;

import com.arkdex.springinaction.disruptorqueue.Ticker;
import com.lmax.disruptor.RingBuffer;

/**
 * Producer that produces event for ring buffer.
 */
public interface EventProducer {
    /**
     * Start the producer that would start producing the values.
     * @param ringBuffer
     * @param count
     */
    public void startProducing(final RingBuffer<Ticker> ringBuffer, final int count);
}
