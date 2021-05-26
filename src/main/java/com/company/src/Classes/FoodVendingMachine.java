package com.company.src.Classes;

import com.company.src.Enums.Food;

public class FoodVendingMachine extends VendingMachine {
    @Override
    protected void fulfill() {
        for(Food item : Food.values()){
            itemInventory.add(item);
        }
    }
}
