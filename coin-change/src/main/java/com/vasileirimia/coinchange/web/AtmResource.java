package com.vasileirimia.coinchange.web;

import com.vasileirimia.coinchange.domain.Coin;
import com.vasileirimia.coinchange.domain.CoinAddData;
import com.vasileirimia.coinchange.service.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * AtmResource
 */
@RestController
public class AtmResource {

    @Autowired AtmService atmService;

    @PostMapping("/deposit")
    public void deposit(@NotNull @RequestBody List<CoinAddData> input) {
        atmService.deposit(input);
    }

    @PostMapping("/withdraw")
    public Map<Integer, Long> withdraw(@NotNull @RequestBody Integer amount) {
        return atmService.widthdraw(amount);
    }
}
