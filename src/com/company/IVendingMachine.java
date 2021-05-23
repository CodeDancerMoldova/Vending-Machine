package com.company;

import java.util.List;

public interface IVendingMachine {

public void insertCoin(Coin coin);
public int selectProductAndGetPrice(Item item);
public Cart returnCart();
public void reset();
public List<Coin> refund();


}
