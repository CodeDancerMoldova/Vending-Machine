package com.company;

public class Cart {

    private Item item;
    private Coin coin;

    public Cart(Item item, Coin coin) {
        this.item = item;
        this.coin = coin;
    }

    public Item getItem() {
        return item;
    }

    public Coin getCoin() {
        return coin;
    }
}

