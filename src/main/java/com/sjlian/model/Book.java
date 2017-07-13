package com.sjlian.model;

/**
 * Created by lian on 17/7/12.
 */
public class Book extends SuperEntity{
    private String name;// 图书名称

    private int number;// 馆藏数量

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
