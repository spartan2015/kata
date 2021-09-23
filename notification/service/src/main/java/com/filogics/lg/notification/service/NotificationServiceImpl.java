package com.filogics.lg.notification.service;

import com.filogics.lg.leads.repository.LeadsRepository;
import com.filogix.lg.loan.service.dto.LoanDTO;
import com.filogix.lg.models.Dropdown;
import lombok.Setter;

import java.util.logging.Logger;

class NotificationServiceImpl implements NotificationService {

    private static final Logger logger = Logger.getLogger(NotificationServiceImpl.class.getSimpleName());

    @Setter
    private SubscriptionRepository subscriptionRepository;
    @Setter
    private LeadsRepository leadsRepository;

    @Override
    public void subscribe(Subscription subscription) {
        subscriptionRepository.save(subscription);
    }

    @Override
    public void unsubscribe(Subscription subscription) {
        subscriptionRepository.remove(subscription);
    }

    public void notify(SubscriptionEvent event){
        LoanDTO lead = leadsRepository.getLead(Dropdown.LanguageEnum.EN_CA, event.getLoanAppId());
        if (lead == null){
            logger.info(String.format("Lead for event not found. loanAppId: %s", event.getLoanAppId()));
            return;
        }
        logger.info(String.format("Notify subscribers of new Lead for loanAppId: %s", event.getLoanAppId()));
        subscriptionRepository.subscriptions(event.getLenderCode(),event.getEvent()).stream()
                .forEach(subscription-> subscription.update(lead));
    }

}
