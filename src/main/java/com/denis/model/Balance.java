package com.denis.model;

import java.math.BigDecimal;

public class Balance {

    public enum Balanced {
        BALANCE, UNBALANCED;
    }

    public final static BigDecimal MIN_SALARY = new BigDecimal("2000");
}
