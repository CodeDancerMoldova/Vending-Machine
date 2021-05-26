package com.company.src.Exceptions;


public class NotFullPaidException extends RuntimeException{
    private String descriptions;
    private int remainingMoney;


    public NotFullPaidException(String descriptions, int remainingMoney) {
        this.descriptions = descriptions;
        this.remainingMoney = remainingMoney;
    }



    public String getDescriptions() {
        return descriptions + remainingMoney;
    }

    public int getRemainingMoney() {
        return remainingMoney;
    }
}
