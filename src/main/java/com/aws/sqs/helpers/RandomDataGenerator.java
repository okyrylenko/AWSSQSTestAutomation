package com.aws.sqs.helpers;

import java.util.Random;

public class RandomDataGenerator {

    public static int randomNumber(){
        return new Random().nextInt(100000);
    }
}
