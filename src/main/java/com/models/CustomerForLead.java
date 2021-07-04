package com.models;

import java.util.Date;
import java.util.List;

public class CustomerForLead{
    private int id;
    private String fName;
    private String lName;
    private List<PurchaseHistory> purchaseHistory;

    public CustomerForLead(int id, String fName, String lName, List<PurchaseHistory> purchaseHistory){
        this.id=id;
        this.fName = fName;
        this.lName = lName;
        this.purchaseHistory = purchaseHistory;
    }
    public List<PurchaseHistory> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(List<PurchaseHistory> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}

