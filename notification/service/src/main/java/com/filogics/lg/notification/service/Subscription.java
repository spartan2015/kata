package com.filogics.lg.notification.service;

import com.filogix.lg.loan.service.dto.LoanDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Subscription {
    String getConnectionId();

    String getLender();

    String getEvent();

    LocalDateTime getCreated();

    void update(LoanDTO lead);
}
