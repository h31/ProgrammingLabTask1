package ru.spbstu.kspt.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


/**
 * Main class
 */

public class PriceList {

    private final List<Product> listOfProducts = new ArrayList<>();


    public void addProduct(String name, int code, double price, int quantity) {
        listOfProducts.add(new Product(name, code, price, quantity));
    }

    private int indexByCode(int currentCode) {
        int result = 0;
        for (int i = 0; i < listOfProducts.size(); i++) {
            if ((listOfProducts.get(i).getCode() == currentCode)) {
                result = i;
                break;
            }
        }
        return result;
    }

    public void removeProduct(int currentCode) {
        listOfProducts.remove(this.indexByCode(currentCode));
    }

    public void thePriceChange(int currentCode, int currentPrice) {
        listOfProducts.get(indexByCode(currentCode)).setPrice(currentPrice);
    }

    public void theNameChange(int currentCode, String currentName) {
        listOfProducts.get(indexByCode(currentCode)).setName(currentName);
    }

    public double theTotalCost(int currentCode, int currentQuantity) {
        return listOfProducts.get(indexByCode(currentCode)).allItemsCost();
    }
}


