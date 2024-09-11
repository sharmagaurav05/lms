package com.lms.lms.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Student")
public class Student {
    @Id
    private String studId;
    private String studName;
    private String studEmail;
    private String studAddress;
    private String studPhoneNo;

    public String getStudId() {
        return studId;
    }

    public void setStudId(String studId) {
        this.studId = studId;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public String getStudEmail() {
        return studEmail;
    }

    public void setStudEmail(String studEmail) {
        this.studEmail = studEmail;
    }

    public String getStudAddress() {
        return studAddress;
    }

    public void setStudAddress(String studAddress) {
        this.studAddress = studAddress;
    }

    public String getStudPhoneNo() {
        return studPhoneNo;
    }

    public void setStudPhoneNo(String studPhoneNo) {
        this.studPhoneNo = studPhoneNo;
    }
}
