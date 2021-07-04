package com.services;

import com.models.Customer;

public class CustomerService {

    public Customer convertNames(Customer customer){
        if(Character.isLowerCase(customer.getfName().charAt(0))){
            String fName = customer.getfName();
            char toReplaceWith = fName.toUpperCase().toCharArray()[0];
            StringBuilder myString = new StringBuilder(fName);
            myString.setCharAt(0, toReplaceWith);
            customer.setfName((myString.toString()));
        }
        if(Character.isLowerCase(customer.getlName().charAt(0))){
            String lName = customer.getlName();
            char toReplaceWith = lName.toUpperCase().toCharArray()[0];
            lName =lName.substring(0, 0) + toReplaceWith + lName.substring(1);
            customer.setlName(lName);
        }

        return customer;
    }
}
