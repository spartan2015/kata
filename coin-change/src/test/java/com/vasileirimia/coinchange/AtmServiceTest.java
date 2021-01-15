package com.vasileirimia.coinchange;

import com.vasileirimia.coinchange.domain.Coin;
import com.vasileirimia.coinchange.domain.CoinAddData;
import com.vasileirimia.coinchange.domain.CoinStore;
import com.vasileirimia.coinchange.domain.InputContraintException;
import com.vasileirimia.coinchange.domain.impl.LimitedCoinsAtm;
import com.vasileirimia.coinchange.service.AtmService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

/**
 * AtmServiceTest
 */
@ExtendWith(MockitoExtension.class)
public class AtmServiceTest {

    public static final String EXPECTED = "Denomination value can only be between 1 and 1000";
    public static final String EXPECTED1 = "Denomination can only appear once";
    @Mock LimitedCoinsAtm limitedCoinsAtm;
    @Mock CoinStore coinStore;
    @InjectMocks AtmService atmService;

    @Test
    public void shouldValidateUniqueDenominationsOnDeposit() {
        Exception ex = Assertions.assertThrows(InputContraintException.class, () -> {
            CoinAddData coinAddData = new CoinAddData(100, 1);
            atmService.deposit(Arrays.asList(coinAddData, coinAddData));
        }, "");
        assertEquals(EXPECTED1, ex.getMessage());
    }

    @Test
    public void shouldValidateDenominationsLimit0OnDeposit() {
        Exception ex = Assertions.assertThrows(InputContraintException.class, () -> {
            CoinAddData coinAddData = new CoinAddData(0, 1);
            atmService.deposit(Arrays.asList(coinAddData));
        }, "");
        assertEquals(EXPECTED, ex.getMessage());
    }

    @Test
    public void shouldValidateDenominationsLimit1001OnDeposit() {
        Exception ex = Assertions.assertThrows(InputContraintException.class, () -> {
            CoinAddData coinAddData = new CoinAddData(1001, 1);
            atmService.deposit(Arrays.asList(coinAddData));
        }, "");
        assertEquals(EXPECTED, ex.getMessage());
    }

    @Test
    public void shouldDeposit() {
        CoinAddData coinAddData = new CoinAddData(1, 1);
        atmService.deposit(Arrays.asList(coinAddData));
        verify(coinStore).put(Coin.fromPence(coinAddData.getDenomination()), coinAddData.getCount());
    }

    @Test
    public void shouldWithdraw() {
        atmService.widthdraw(1);
        verify(limitedCoinsAtm).widthdraw(1);
    }
}
