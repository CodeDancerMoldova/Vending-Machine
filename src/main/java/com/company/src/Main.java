package com.company.src;

import com.company.src.Classes.VendingMachine;
import com.company.src.Classes.VendingMachineFactory;
import com.company.src.Enums.Coin;
import com.company.src.Enums.Food;

public class Main {

    public static void main(String[] args) {

        VendingMachine vendingMachine = VendingMachineFactory.createFoodVendingMachine();
        vendingMachine.insertCoin(Coin.PENNY);
        vendingMachine.insertCoin(Coin.PENNY);
        vendingMachine.insertCoin(Coin.PENNY);
        vendingMachine.insertCoin(Coin.PENNY);
        vendingMachine.insertCoin(Coin.PENNY);
        vendingMachine.insertCoin(Coin.PENNY);

        System.out.println(vendingMachine.selectProductAndGetPrice(Food.Lemonade));
        vendingMachine.returnCart().printCart();

        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.NICKLE);
        vendingMachine.insertCoin(Coin.PENNY);
        vendingMachine.insertCoin(Coin.NICKLE);
        vendingMachine.insertCoin(Coin.PENNY);

        System.out.println(vendingMachine.selectProductAndGetPrice(Food.SNACKS));
        System.out.println(vendingMachine.selectProductAndGetPrice(Food.SELTZER));
        vendingMachine.returnCart().printCart();

    }
}
