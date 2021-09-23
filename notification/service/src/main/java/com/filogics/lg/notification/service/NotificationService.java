package com.filogics.lg.notification.service;

public interface NotificationService {

    void subscribe(Subscription subscription);

    void unsubscribe(Subscription subscription);

    void notify(SubscriptionEvent event);
}
