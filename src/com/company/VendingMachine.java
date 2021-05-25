package com.company;

import com.company.Exceptions.NotFullPaidException;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine implements IVendingMachine{

    public ArrayList<Item> itemInventory = new ArrayList<>();
    public ArrayList<Coin> coinsInventory = new ArrayList<>();
    public List<Coin> currentCoins = new ArrayList<>();

private Item currentItem;
private boolean insertedCoin = false;
public int currentBalance = 0;

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
           currentBalance+=coin.getDenomination();
           insertedCoin = true;

    }

    @Override
    public int selectProductAndGetPrice(Item item){
        currentItem = null;
        if(itemInventory.contains(item)){
            currentItem = item;
            return item.getPrice();
        }
        return 0;
    }

    @Override
    public Cart returnCart() throws NotFullPaidException {
           int remaining;
           List<Coin> rest = new ArrayList<>();
           if(currentItem.getPrice() == currentBalance){
               balance+=currentBalance;
               currentBalance = 0;
               return new Cart(currentItem,rest);
           }
           else if(currentItem.getPrice() > currentBalance){
               remaining = currentItem.getPrice() - currentBalance;
               throw new NotFullPaidException("You must pay the remaining money ", remaining);
           }
           else if(currentItem.getPrice() < currentBalance){
               remaining = currentBalance - currentItem.getPrice();
                while (remaining > 0){
                    if(remaining>=Coin.QUARTER.getDenomination() && coinsInventory.contains(Coin.QUARTER)){
                        remaining -= Coin.QUARTER.getDenomination();
                        rest.add(Coin.QUARTER);
                    }
                    else if(remaining>=Coin.DIME.getDenomination() && coinsInventory.contains(Coin.DIME)){
                        remaining -= Coin.DIME.getDenomination();
                        rest.add(Coin.DIME);
                    }
                    else if(remaining>=Coin.NICKLE.getDenomination() && coinsInventory.contains(Coin.NICKLE)){
                        remaining-= Coin.NICKLE.getDenomination();
                        rest.add(Coin.NICKLE);
                    }
                    else if(remaining>=Coin.PENNY.getDenomination() && coinsInventory.contains(Coin.PENNY)){
                        remaining -= Coin.PENNY.getDenomination();
                        rest.add(Coin.PENNY);
                    }
                    else{
                        System.out.println("Not enough rest!");
                    }
                }
                balance+=currentBalance;
                currentBalance = 0;
                currentCoins.clear();
                return new Cart(currentItem,rest);
           }

        return null;
    }

    @Override
    public void reset(){
        coinsInventory.clear();
        itemInventory.clear();
        currentCoins.clear();
        balance = 0;
        currentItem = null;
        fulfill();
    }

    @Override
    public void refund() {
        if(insertedCoin == true){
            for(Coin c : currentCoins){
                coinsInventory.remove(c);
                currentBalance-=c.getDenomination();
            }
            insertedCoin = false;
            currentCoins.clear();
        }
    }
}
