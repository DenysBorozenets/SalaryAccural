package com.denis.model;

import java.math.BigDecimal;

public class Fund {

    private Balance.Balanced balance;
    private BigDecimal sum;

    public Fund(Balance.Balanced balance, BigDecimal sum) {
        this.balance = balance;
        this.sum = sum;
    }

    public Balance.Balanced getBalance() {
        return balance;
    }

    public void setBalance(Balance.Balanced balance) {
        this.balance = balance;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
