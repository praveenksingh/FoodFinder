package com.findmefood.model;

public class RestaurantDetails {

    private final String name;
    private final String address;
    private final String phone;

    public RestaurantDetails(String id, String content, String phone) {
        this.name = id;
        this.address = content;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

}
