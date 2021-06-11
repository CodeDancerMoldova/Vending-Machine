package com.company.src.Classes;

import com.company.src.Enums.Coin;
import com.company.src.Exceptions.NotFullPaidException;
import com.company.src.Exceptions.NotInStock;
import com.company.src.Interfaces.Item;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public  abstract class VendingMachine{

    protected List<Item> itemInventory = new ArrayList<>();
    protected LinkedList<Coin> coinsInventory = new LinkedList<>();
    private   List<Coin> currentCoins = new ArrayList<>();
    private   List<Item> currentItems = new ArrayList<>();
    private boolean insertedCoin = false;
    private int currentBalance = 0;
    private int balance = 0;

    public List<Coin> getCurrentCoins() {
        return currentCoins;
    }

    public VendingMachine() {
        for(Coin coin : Coin.values()){
            coinsInventory.add(coin);
        }
        fulfill();
    }

    protected abstract void fulfill();

    public void insertCoin(Coin coin){
           currentCoins.add(coin);
           coinsInventory.add(coin);
           currentBalance+=coin.getDenomination();
           insertedCoin = true;
    }


    public int selectProductAndGetPrice(Item item){
        if(itemInventory.contains(item)){
            currentItems.add(item);
            return item.getPrice();
        }
        else{
            throw new NotInStock("Such a thing is not in stock, chose something else!!");
        }
    }


    public Cart returnCart() throws NotFullPaidException {
           int remaining;
           int finalPrice = 0;
           List<Coin> rest = new ArrayList<>();
           List<Item> myItems= new ArrayList<>();
           for(Item item :currentItems){
               finalPrice+=item.getPrice();
           }
           if(finalPrice == currentBalance){
               balance+=currentBalance;
               currentBalance = 0;
               myItems.addAll(currentItems);
               currentItems.clear();
               for(Item i : myItems){
                   itemInventory.remove(i);
               }
               return new Cart(myItems,rest);
           }
           else if(finalPrice > currentBalance){
               remaining = finalPrice - currentBalance;
               throw new NotFullPaidException("You must pay the remaining money ", remaining);
           }
           else if(finalPrice < currentBalance){
               remaining = currentBalance - finalPrice;
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
                myItems.addAll(currentItems);
                currentItems.clear();
               for(Item i : myItems){
                   itemInventory.remove(i);
               }
                return new Cart(myItems,rest);
           }

        return null;
    }


    public void reset(){
        coinsInventory.clear();
        itemInventory.clear();
        currentCoins.clear();
        balance = 0;
        currentItems.clear();
        fulfill();
    }

    public void refund() {
        if(insertedCoin){
            for(Coin c : currentCoins){
                coinsInventory.removeFirstOccurrence(c);
                currentBalance-=c.getDenomination();
            }
            insertedCoin = false;
            currentCoins.clear();
        }
    }

}
