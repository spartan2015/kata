package com.filogics.lg.notification.service;

import java.util.List;

public interface SubscriptionRepository {

    void save(Subscription subscription);
    void remove(Subscription subscription);
    List<Subscription> subscriptions(String lender, String event);
}
