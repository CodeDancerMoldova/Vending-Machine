package com.company.src.Test;

import com.company.src.Classes.Cart;
import com.company.src.Classes.VendingMachine;
import com.company.src.Classes.VendingMachineFactory;
import com.company.src.Enums.Coin;
import com.company.src.Enums.Med;
import com.company.src.Interfaces.Item;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class VendingMachineTest {
    private static VendingMachine medVendingMachine;

    @BeforeAll
    public static void setUp(){
        medVendingMachine = VendingMachineFactory.createMedVendingMachine();
    }


    @AfterAll
    public static void setDown(){
        medVendingMachine = null;
    }

    @Test
    public void testBuyItemWithNoChange(){

        int price = medVendingMachine.selectProductAndGetPrice(Med.MEDICALFACEMASK);
        assertEquals(Med.MEDICALFACEMASK.getPrice(),price);

        medVendingMachine.insertCoin(Coin.PENNY);
        medVendingMachine.insertCoin(Coin.PENNY);
        medVendingMachine.insertCoin(Coin.PENNY);

        List<Item> testMeds = new ArrayList<>();
        testMeds.add(Med.MEDICALFACEMASK);
        ArrayList<Coin> testChange = new ArrayList<>();
        testChange.add(Coin.PENNY);


        Cart cart = new Cart(testMeds,testChange);
        Cart cartTest =  medVendingMachine.returnCart();

        assertEquals(cartTest.getItems().get(0),cartTest.getItems().get(0));

        assertTrue(cartTest.getFinalChange() == cart.getFinalChange());


    }


}
