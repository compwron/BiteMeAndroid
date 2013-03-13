package com.thoughtworks.yelp.service.wiretypes;

public class BusinessWireType {
    private final String phone;

    public BusinessWireType() { this(null); }

    public BusinessWireType(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
}
