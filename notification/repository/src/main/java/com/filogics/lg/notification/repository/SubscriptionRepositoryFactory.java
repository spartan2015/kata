package com.filogics.lg.notification.repository;

import com.filogics.lg.notification.service.SubscriptionRepository;
import com.filogix.repository.MongoRepositoryFactory;

public class SubscriptionRepositoryFactory {

    private static SubscriptionRepositoryImpl instance;

    public static SubscriptionRepository getInstance() {
        if (instance == null){
            instance = new SubscriptionRepositoryImpl();
            instance.setMongoRepository(MongoRepositoryFactory.getMongoRepository());
        }
        return instance;
    }
}
