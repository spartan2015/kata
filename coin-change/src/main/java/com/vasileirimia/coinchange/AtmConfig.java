package com.vasileirimia.coinchange;

import com.vasileirimia.coinchange.domain.CoinStore;
import com.vasileirimia.coinchange.domain.LimitedBillsCoinStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AtmConfig
 */
@Configuration
public class AtmConfig {

    @Bean
    CoinStore getCoinStore() {
        return new LimitedBillsCoinStore();
    }

}
