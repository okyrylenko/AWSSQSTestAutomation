package com.models;

import com.aws.sqs.helpers.RandomDataGenerator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
    private int id;
    private String fName;
    private String lName;
    private Date dateOfBirth;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    public int getId() {
        return id;
    }

    public void setId() {
        if(this.id==0){
            this.id = RandomDataGenerator.randomNumber();
        }
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Date getdateOfBirth() {
        return dateOfBirth;
    }

    public void setdateOfBirth(String dob) throws ParseException {
        this.dateOfBirth = new SimpleDateFormat("dd/M/yyyy").parse(dob);
    }
}
