package com.arkdex.springinaction.disruptorqueue;

import com.lmax.disruptor.EventFactory;

public class Ticker {
    private int sourceId;
    private double price = 0;
    private long date;

    public Ticker() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String test(String input) {
        return "Hello world!";
    }

    public Ticker(int sourceId, double price, long date) {
        this.sourceId = sourceId;
        this.price = price;
        this.date = date;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public final static EventFactory<Ticker> EVENT_FACTORY = () -> new Ticker();
}
