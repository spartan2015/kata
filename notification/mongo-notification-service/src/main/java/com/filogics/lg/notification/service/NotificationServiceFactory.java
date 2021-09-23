package com.filogics.lg.notification.service;

import com.filogics.lg.leads.repository.LeadsRepositoryImpl;
import com.filogics.lg.notification.repository.SubscriptionRepositoryFactory;

public class NotificationServiceFactory {
    private static NotificationService notificationService;

    public static NotificationService getNotificationService() {
        if (notificationService == null) {
            NotificationServiceImpl impl = new NotificationServiceImpl();
            impl.setSubscriptionRepository(SubscriptionRepositoryFactory.getInstance());
            impl.setLeadsRepository(new LeadsRepositoryImpl());
            notificationService = impl;
        }
        return notificationService;
    }
}
