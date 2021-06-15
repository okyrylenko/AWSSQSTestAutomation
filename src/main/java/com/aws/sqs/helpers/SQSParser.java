package com.aws.sqs.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.models.Customer;
import software.amazon.awssdk.services.sqs.model.Message;

import java.util.ArrayList;
import java.util.List;

public class SQSParser {

    public static <T> ArrayList<T> parseSQSMessageToObjects(List<Message> messages, Class<T> clazz) throws JsonProcessingException {
        List<T> customers = new ArrayList<>();

        for(Message message:messages){
            customers.add(JsonParser.toObject(message.body(), clazz));
        }

        return (ArrayList<T>) customers;
    }
}
