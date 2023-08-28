package com.example.loginhomevalid.controllingsec;

public class Booking {
    private int id;
    private String name;
    private String destination;
    private int price;
    public Booking(int id, String name, String destination, int price) {
        this.id = id;
        this.name = name;
        this.destination = destination;
        this.price = price;
    }
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
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
