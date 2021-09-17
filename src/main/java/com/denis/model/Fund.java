package com.denis.model;

import java.math.BigDecimal;

public class Fund {

    private BigDecimal sum;
    private Balance balance;

    public Fund(Balance balance) {
        this(new BigDecimal("0"), balance);
    }

    public Fund(BigDecimal sum, Balance balance) {
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

    public enum Balance {BALANCED,UNBALANCED;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fund fund = (Fund) o;
        return sum.equals(fund.sum) &&  balance == fund.balance;
    }

    @Override
    public int hashCode() {
        int number = 31;
        int result = (sum.hashCode() * number + balance.hashCode()) * number;
        return result;
    }
}
