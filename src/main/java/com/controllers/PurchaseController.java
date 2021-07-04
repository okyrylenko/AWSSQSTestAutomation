package com.controllers;

import com.aws.sqs.helpers.PurchaseRepo;
import com.models.PurchaseHistory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseController {

    public PurchaseController(){}

    @PostMapping(value = "/purchase")
    public ResponseEntity customer(@RequestBody PurchaseHistory purchase) {
        try{
            PurchaseRepo.addPurchase(purchase);
            return new ResponseEntity<>(purchase, HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
