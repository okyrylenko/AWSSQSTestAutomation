package com.aws.sqs.helpers;

import com.models.Customer;
import com.models.Product;
import com.models.PurchaseHistory;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerDecorator {
    private Customer customer;

    public CustomerDecorator(Customer customer){
        this.customer = customer;
    }

    public Customer setId(){
        this.customer.setId();
        return this.customer;
    }

}
