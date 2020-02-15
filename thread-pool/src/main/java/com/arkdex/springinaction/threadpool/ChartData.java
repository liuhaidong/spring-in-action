package com.arkdex.springinaction.threadpool;

import java.util.Date;

public class ChartData {


    private Integer id;
    private Double price;
    private Date date;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    private String from;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ChartData(Integer id, Double price, Date date) {
        this.id = id;
        this.price = price;
        this.date = date;
    }

    public ChartData(Integer id, Double price, Date date, String from) {
        this.id = id;
        this.price = price;
        this.date = date;
        this.from = from;
    }
}
