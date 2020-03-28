package com.arkdex.springinaction.disruptorqueue.ticker;

import com.arkdex.springinaction.disruptorqueue.Ticker;
import com.lmax.disruptor.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiEventPrintConsumer implements EventConsumer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    @SuppressWarnings("unchecked")
    public EventHandler<Ticker>[] getEventHandler() {
        final EventHandler<Ticker> eventHandler = (event, sequence, endOfBatch) -> print(event.getDate(), sequence,event.getSourceId(), 0);
        final EventHandler<Ticker> otherEventHandler = (event, sequence, endOfBatch) -> print(event.getDate(), sequence,event.getSourceId(),1);
        return new EventHandler[] { eventHandler, otherEventHandler };
    }

    private void print(final long epoch, final long sequenceId,final int sourceId, int consumerId) {
        logger.info("date epoch is " + epoch +" sourceId is "+sourceId+"; sequence id that was used is " + sequenceId +"; consumed by " + consumerId);
    }
}
