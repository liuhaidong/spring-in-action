package com.arkdex.springinaction.disruptorqueue.ticker;

import com.arkdex.springinaction.disruptorqueue.Ticker;
import com.lmax.disruptor.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingleEventPrintConsumer implements EventConsumer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    @SuppressWarnings("unchecked")
    public EventHandler<Ticker>[] getEventHandler() {
        final EventHandler<Ticker> eventHandler = (event, sequence, endOfBatch) -> print(event.getDate(),sequence,
                event.getSourceId());
        return new EventHandler[] { eventHandler };
    }

    private void print(final long id, final long sequenceId,int sourceId) {
        logger.info("date epoch is " + id +" sourceId is "+sourceId+"; that was used is " + " sequence id," +sequenceId);
    }
}
