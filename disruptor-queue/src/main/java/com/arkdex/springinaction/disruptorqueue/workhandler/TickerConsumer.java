package com.arkdex.springinaction.disruptorqueue.workhandler;

import com.arkdex.springinaction.disruptorqueue.Ticker;
import com.lmax.disruptor.WorkHandler;

public class TickerConsumer implements WorkHandler<Ticker> {
    @Override
    public void onEvent(Ticker longEvent) throws Exception {
        System.out.println(Thread.currentThread().getName() + "date: " + longEvent.getDate());
    }
}
