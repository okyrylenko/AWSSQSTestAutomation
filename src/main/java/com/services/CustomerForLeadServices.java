package com.services;

import com.aws.sqs.helpers.PurchaseRepo;
import com.models.Customer;
import com.models.CustomerForLead;
import com.models.PurchaseHistory;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerForLeadServices {
    public CustomerForLead EnrichWithPurchaseHistory(Customer customer){
        List<PurchaseHistory> history = PurchaseRepo.getPurchases()
                .stream().filter(p->p.getEmail().equals(customer.getEmail())).collect(Collectors.toList());

        return new CustomerForLead(customer.getId(), customer.getfName(), customer.getlName(), customer.getdateOfBirth(), history);
    }

}
