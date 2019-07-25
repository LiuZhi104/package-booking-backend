package com.oocl.packagebooking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Package {
    @Id
    @GeneratedValue
    private long id;
    private  String custumerName;
    private  String phoneNum;
    private int status;
    private Date startTime;

    public Package(long id, String custumerName, String phoneNum, int status, Date startTime) {
        this.id = id;
        this.custumerName = custumerName;
        this.phoneNum = phoneNum;
        this.status = status;
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", custumerName='" + custumerName + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", status=" + status +
                ", startTime=" + startTime +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustumerName() {
        return custumerName;
    }

    public void setCustumerName(String custumerName) {
        this.custumerName = custumerName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
