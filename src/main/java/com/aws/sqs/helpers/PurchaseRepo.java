package com.aws.sqs.helpers;

import com.models.PurchaseHistory;

import java.util.ArrayList;
import java.util.List;

public class PurchaseRepo {
    private static List<PurchaseHistory> purchases = new ArrayList<>();

    public static List<PurchaseHistory> getPurchases() {
        return purchases;
    }

    public static void addPurchase(PurchaseHistory purchase) {
        purchases.add(purchase);
    }
}
