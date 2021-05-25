package com.company;

import java.util.List;

public class Cart {

    private List<Item> items;
    private List<Coin> coins;

    public Cart(List<Item> items, List<Coin> coins) {
        this.items = items;
        this.coins = coins;
    }

    public void printCart(){
        int finalChange=0;
        System.out.print("The products are:");
        for(Item item : items){
            System.out.print(" " + item.getName() );
        }

        if(coins==null){
            System.out.println("No change!");
        }
        else{
            for(Coin c : coins){
                finalChange += c.getDenomination();
            }
            System.out.println(",rest: "+ finalChange);
        }

    }
}

