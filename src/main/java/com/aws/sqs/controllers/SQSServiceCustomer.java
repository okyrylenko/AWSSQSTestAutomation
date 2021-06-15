package com.aws.sqs.controllers;

import com.aws.sqs.helpers.JsonParser;
import com.aws.sqs.helpers.SQSParser;
import com.services.sqs.BaseSQSClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.Customer;
import jdk.internal.net.http.websocket.BuilderImpl;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.model.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQSServiceCustomer extends BaseSQSClient {
    private final String QUEUEURL = "https://sqs.us-east-2.amazonaws.com/962312104812/Customers";
    private final String ATTRIBUTE = "Customer";

    public SQSServiceCustomer() {
        super(Region.US_EAST_2);
    }

    public SendMessageResponse sendCustomerToQueue(Customer customer) throws JsonProcessingException {
        String message = new ObjectMapper().setDateFormat(new SimpleDateFormat("dd/M/yyyy")).writeValueAsString(customer);

        final Map<String, MessageAttributeValue> messageAttributes = new HashMap<>();
        messageAttributes.put("Name", MessageAttributeValue.builder().dataType("String").stringValue(ATTRIBUTE).build());


        SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
                .queueUrl(this.QUEUEURL)
                .messageBody(message)
                .messageAttributes(messageAttributes)
                .build();
        return super.sendMessage(sendMessageRequest);
    }

    public Customer getCustomerFromQueue(int id) throws JsonProcessingException {
        Customer customer = null;
        String receiptHandle =null;
        List<Message> messages = this.getMessages();

        for(Message message:messages){
            Customer cus = JsonParser.toObject(message.body(), Customer.class);
            if(cus.getId() == id){
                customer =cus;
                receiptHandle = message.receiptHandle();
                break;
            }
        }

        if(receiptHandle !=null){
            DeleteMessageResponse m = this.deleteMessage(receiptHandle);
        }
        return customer;
    }

    public DeleteMessageResponse deleteMessage(String receiptHandle){
        DeleteMessageRequest request = DeleteMessageRequest.builder()
                .queueUrl(this.QUEUEURL)
                .receiptHandle(receiptHandle)
                .build();

        return super.deleteMessage(request);

    }


    public ArrayList<Customer> getCustomersFromQueue() throws JsonProcessingException {
        List<Message> messages = this.getMessages();
        return SQSParser.parseSQSMessageToObjects(messages, Customer.class);
    }

    private List<Message> getMessages(){
        ReceiveMessageRequest request = ReceiveMessageRequest.builder()
                .queueUrl(this.QUEUEURL)
                .build();

        return super.getMessages(request).messages();
    }


}
