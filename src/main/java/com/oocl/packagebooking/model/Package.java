package com.oocl.packagebooking.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Package {
    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private Customer customer;
    @Column(nullable = false)
    private String status;
    private long startTime;

    public Package() {
    }

    public Package(String status, long startTime) {
        this.status = status;
        this.startTime = startTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
}

