package com.company;

import java.util.List;

public class Cart {

    private Item item;
    private List<Coin> coins;

    public Cart(Item item, List<Coin> coins) {
        this.item = item;
        this.coins = coins;
    }

    public Item getItem() {
        return item;
    }


    public void printCart(){
        int finalChange=0;
        System.out.print("The product:" + item.getName());
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

