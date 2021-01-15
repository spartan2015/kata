package com.vasileirimia.coinchange.service;

import com.vasileirimia.coinchange.domain.CoinStore;
import com.vasileirimia.coinchange.domain.Coin;
import com.vasileirimia.coinchange.domain.CoinAddData;
import com.vasileirimia.coinchange.domain.InputContraintException;
import com.vasileirimia.coinchange.domain.impl.LimitedCoinsAtm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * AtmService
 */
@Component
public class AtmService {

    @Autowired LimitedCoinsAtm limitedCoinsAtm;
    @Autowired CoinStore coinStore;

    public void deposit(List<CoinAddData> inputData) {
        validate(inputData);
        for(CoinAddData data : inputData){
            coinStore.put(Coin.fromPence(data.getDenomination()), data.getCount());
        }
    }

    private void validate(List<CoinAddData> inputData){
        Set<Integer> denominations = new HashSet<>();
        for(CoinAddData data : inputData){
            boolean added = denominations.add(data.getDenomination());
            if (!added){
                throw new InputContraintException("Denomination can only appear once");
            }
            if ( data.getDenomination() < 1 || data.getDenomination() > 1000){
                throw new InputContraintException("Denomination value can only be between 1 and 1000");
            }
            if ( data.getCount() < 1 || data.getCount() > 100_000){
                throw new InputContraintException("Count value can only be between 1 and 100000");
            }
        }
    }

    public Map<Integer, Long> widthdraw(int amount) {
        return limitedCoinsAtm.widthdraw(amount)
                .stream()
                .collect(Collectors.groupingBy(coin->coin.getPence(), Collectors.counting()));
    }
}
