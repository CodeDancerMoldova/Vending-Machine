package com.company.src.Classes;

import com.company.src.Enums.Coin;
import com.company.src.Interfaces.Item;

import java.util.List;

public class Cart {

    private List<Item> items;
    private List<Coin> coins;
    private int finalChange = 0;

    public Cart(List<Item> items, List<Coin> coins) {
        this.items = items;
        this.coins = coins;
    }

    public int getFinalChange() {
        return finalChange;
    }

    public List<Item> getItems() {
        return items;
    }

    public void printCart(){
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

