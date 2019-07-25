package com.oocl.packagebooking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String name;
    private String phone;

    public Customer() {
    }

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
