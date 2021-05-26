package com.company.src.Classes;

public class VendingMachineFactory {

    public  static FoodVendingMachine createFoodVendingMachine() {
        return new FoodVendingMachine();
    }
    public  static MedVendingMachine createMedVendingMachine() {
        return new MedVendingMachine();
    }
}
