package com.aws.sqs.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {

    public static <T> T toObject(String data, Class<T> o) throws JsonProcessingException {
        return new ObjectMapper().readValue(data, o);
    }

}
