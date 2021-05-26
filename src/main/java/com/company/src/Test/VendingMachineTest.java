package com.company.src.Test;

import com.company.src.Classes.Cart;
import com.company.src.Classes.VendingMachine;
import com.company.src.Classes.VendingMachineFactory;
import com.company.src.Enums.Coin;
import com.company.src.Enums.Med;
import com.company.src.Exceptions.NotInStock;
import com.company.src.Interfaces.Item;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


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

    @Test
    public void testNotInStock(){
        assertThrows(NotInStock.class,()->{
            for(int i =0;i<5;i++){
                int price = medVendingMachine.selectProductAndGetPrice(Med.AlCOHOLHANDCLEANSER);
                medVendingMachine.insertCoin(Coin.QUARTER);
                medVendingMachine.returnCart();
            }
        });

    }


    @Test
    public void testReturnCartWithMoreThanOneProduct(){
        int price = medVendingMachine.selectProductAndGetPrice(Med.AlCOHOLHANDCLEANSER);
        int price_2 = medVendingMachine.selectProductAndGetPrice(Med.MEDICALFACEMASK);
        medVendingMachine.insertCoin(Coin.QUARTER);
        Cart cart = medVendingMachine.returnCart();
        assertEquals(cart.getItems().get(0) , Med.AlCOHOLHANDCLEANSER);
        assertEquals(cart.getItems().get(1) , Med.MEDICALFACEMASK);

    }


}
