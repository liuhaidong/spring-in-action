package com.arkdex.springinaction.cglibproxy;

public class Ticker {
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

    public Ticker(double price, long date) {
        this.price = price;
        this.date = date;
    }
}
