package com.kuang.entity;

public class User {
    private int id ;
    private String name ;
    private int value;
    private int chazhi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getChazhi() {
        return chazhi;
    }

    public void setChazhi(int chazhi) {
        this.chazhi = chazhi;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", chazhi=" + chazhi +
                '}';
    }
}
