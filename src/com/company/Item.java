package com.company;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Item {
    SNACKS("Snacks",25), SELTZER("Seltzer",10) , CHIPS("Chips",15), Lemonade(" Lemonade",5);
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
