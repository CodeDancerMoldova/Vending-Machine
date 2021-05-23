package com.company;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Coin {
    PENNY(1), NICKLE(5), DIME(10), QUARTER(25);
    private int denomination;
    public int getDenomination() {
        return denomination;
    }
}
