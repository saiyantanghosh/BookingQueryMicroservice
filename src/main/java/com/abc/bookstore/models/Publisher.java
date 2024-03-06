package com.abc.bookstore.models;

import java.util.Optional;

public class Publisher {
    private String name;
    private String registeredName;
    private String registrationNumber;

    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegisteredName() {
        return registeredName;
    }

    public void setRegisteredName(String registeredName) {
        this.registeredName = registeredName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    public Address getAddress() {
        return address;
    }

    /*public Optional<Address> getAddress() {
        return address;
    }*/
    // having an Optional parameter represents one of three states: a null Optional, a non-null Optional with isPresent() == false and a non-null Optional wrapping an actual value.
    public void setAddress(Address address) {
        this.address = address;
    }
}
