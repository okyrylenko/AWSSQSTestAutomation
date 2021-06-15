package com.services.sqs;

import software.amazon.awssdk.services.sqs.model.*;

public interface IBaseSQSClient {
    SendMessageResponse sendMessage(SendMessageRequest sendMessageRequest);

    ReceiveMessageResponse getMessages(ReceiveMessageRequest request);

    DeleteMessageResponse deleteMessage(DeleteMessageRequest request);
}
