package com.vasileirimia.coinchange.domain;

/**
 * CoinAddRequest
 */
public class CoinAddData {
    private Integer denomination;
    private Integer count;

    public CoinAddData(){

    }

    public CoinAddData(Integer denomination, Integer count) {
        this.denomination = denomination;
        this.count = count;
    }

    public Integer getDenomination() {
        return denomination;
    }

    public void setDenomination(Integer denomination) {
        this.denomination = denomination;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
