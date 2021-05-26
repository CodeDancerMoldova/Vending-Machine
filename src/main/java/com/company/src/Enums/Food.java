package com.company.src.Enums;

import com.company.src.Interfaces.Item;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Food implements Item {
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
