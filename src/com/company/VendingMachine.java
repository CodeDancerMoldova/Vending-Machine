package com.company;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine implements IVendingMachine{

ArrayList<Item> itemInventory = new ArrayList<>();
ArrayList<Coin> coinsInventory = new ArrayList<>();
private List<Coin> currentCoins = new ArrayList<>();

private Item currentItem;
private boolean insertedCoin = false;
private int currentIndex;

private int balance = 0;

    public VendingMachine() {
        fulfill();
    }

    private void fulfill(){
    for(Coin coin : Coin.values()){
         coinsInventory.add(coin);
    }
    for(Item item : Item.values()){
        itemInventory.add(item);
    }
}

    @Override
    public void insertCoin(Coin coin){
           currentCoins.add(coin);
           coinsInventory.add(coin);
           currentIndex = coinsInventory.indexOf(coin);
           balance+=coin.getDenomination();
           insertedCoin = true;

    }

    @Override
    public int selectProductAndGetPrice(Item item){
        if(itemInventory.contains(item)){
            currentItem = item;
            return item.getPrice();
        }
        return 0;
    }

    @Override
    public Cart returnCart() {


        return null;
    }

    @Override
    public void reset(){
        coinsInventory.clear();
        itemInventory.clear();
        currentCoins.clear();
        balance = 0;
        currentIndex = 0;
        currentItem = null;
        fulfill();
    }

    @Override
    public List<Coin> refund() {
        if(insertedCoin == true){
            for(Coin c : currentCoins){
                coinsInventory.remove(c);
                balance-=c.getDenomination();
            }
            return currentCoins;
        }
        return null;
    }
}
