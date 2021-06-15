package com.services;

import com.aws.sqs.controllers.SQSServiceCustomer;
import com.aws.sqs.helpers.CustomerDecorator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.models.Customer;
import com.models.CustomerForLead;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.services.sqs.model.SendMessageResponse;

@RestController
public class CustomerController {

    SQSServiceCustomer sqsCustomer;
    CustomerController(){
        sqsCustomer = new SQSServiceCustomer();
    }
    @PostMapping(value = "/customer")
    public ResponseEntity customer(@RequestBody Customer customer) {
        try{
            customer = new CustomerDecorator(customer).setId();
            SendMessageResponse response =  sqsCustomer.sendCustomerToQueue(customer);
            return new ResponseEntity<>(customer, HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value ="/customer/{id}")
    public ResponseEntity customer(@PathVariable(value = "id")  int id) {
        try{
            Customer customer =  sqsCustomer.getCustomerFromQueue(id);
            if(customer == null){
                return new ResponseEntity<>("No customer with id " + id + " exists", HttpStatus.NOT_FOUND);
            }
            CustomerForLead customerForLead = new CustomerForLeadServices().EnrichWithPurchaseHistory(customer);
            return new ResponseEntity<>(customerForLead,HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
