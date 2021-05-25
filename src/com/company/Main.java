package com.company;

public class Main {

    public static void main(String[] args) {

        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(Coin.PENNY);
        vendingMachine.insertCoin(Coin.PENNY);
        vendingMachine.insertCoin(Coin.PENNY);
        vendingMachine.insertCoin(Coin.PENNY);
        vendingMachine.insertCoin(Coin.PENNY);
        vendingMachine.insertCoin(Coin.PENNY);

        System.out.println(vendingMachine.selectProductAndGetPrice(Item.Lemonade));
        vendingMachine.returnCart().printCart();

        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.NICKLE);
        vendingMachine.insertCoin(Coin.PENNY);
        vendingMachine.insertCoin(Coin.NICKLE);
        vendingMachine.insertCoin(Coin.PENNY);

        System.out.println(vendingMachine.selectProductAndGetPrice(Item.SNACKS));
        System.out.println(vendingMachine.selectProductAndGetPrice(Item.SELTZER));
        vendingMachine.returnCart().printCart();

    }
}
