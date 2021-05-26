package com.company.src.Enums;

import com.company.src.Interfaces.Item;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Med implements Item {

AlCOHOLHANDCLEANSER("Alcohol Hand Cleanser", 10), MEDICALFACEMASK("Medical FACE Mask",2),VITAMINES("Vitamine C",5);
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
