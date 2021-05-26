package com.company.src.Classes;

import com.company.src.Enums.Med;

public class MedVendingMachine extends VendingMachine{

    @Override
    protected void fulfill() {
        for(Med item : Med.values()){
            itemInventory.add(item);
        }
    }
}
