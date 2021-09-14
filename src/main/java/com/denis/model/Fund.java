package com.denis.model;

import java.math.BigDecimal;

public class Fund {

    private Balance balance;
    private BigDecimal sum;

    public Fund(Balance balance, BigDecimal sum) {
        this.balance = balance;
        this.sum = sum;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
