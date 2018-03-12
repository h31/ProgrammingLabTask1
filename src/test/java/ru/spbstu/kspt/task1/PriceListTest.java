package ru.spbstu.kspt.task1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.HashMap;
import java.util.Map;


class PriceListTest {
    private static Logger log = Logger.getLogger(PriceListTest.class.getName());

    @Test
    void testAddProduct() {
        log.log(Level.FINE, "Test on adding a product has started");
        PriceList newPricelist = new PriceList();
        Map<Integer, Product> testMap = new HashMap<>();
        testMap.put(001, new Product(001, "Popcorn", new Price(99, 99), 5));
        testMap.put(002, new Product(002, "Cookies",
                new Price(500, 00), 10));
        newPricelist.addProduct(001, "Popcorn", 98, 99, 5);
        newPricelist.addProduct(002, "Cookies",
                550, 00, 10);
        assertNotEquals(newPricelist.pricelist, testMap);
        log.log(Level.FINE, "Test on adding a product has finished");
    }

    @Test
    void testRemoveProduct() {
        log.log(Level.FINE, "Test on removing a product has started");
        PriceList newPricelist = new PriceList();
        newPricelist.addProduct(01, "Pudding", 48, 49, 4);
        newPricelist.addProduct(02, "Frozen Pizza", 229, 20, 1);
        newPricelist.addProduct(03, "Coke", 42, 0, 50);
        newPricelist.addProduct(04, "Berries", 400, 99, 100);
        newPricelist.removeProduct(03);
        newPricelist.removeProduct(04);
        assertEquals(newPricelist.pricelist.size(), 2);
        log.log(Level.FINE, "Test on removing a product has finished");
    }

    @Test
    void testRemoveNonExistedProduct() throws IllegalArgumentException {
        log.log(Level.FINE, "Test on removing a product has started");
        PriceList newPricelist = new PriceList();
        newPricelist.addProduct(01, "Pudding", 48, 49, 4);
        newPricelist.addProduct(02, "Frozen Pizza", 229, 20, 1);
        newPricelist.addProduct(03, "Coke", 42, 0, 50);
        newPricelist.addProduct(04, "Berries", 400, 99, 100);
        newPricelist.removeProduct(10);
        log.log(Level.FINE, "Test on removing a product has finished");
    }

    @Test
    void testNameChange() {
        log.log(Level.FINE, "Test on replacing a name of the product has started");
        PriceList newPricelist = new PriceList();
        newPricelist.addProduct(01, "Pudding", 48, 49, 4);
        newPricelist.addProduct(02, "Frozen Pizza", 229, 20, 1);
        newPricelist.addProduct(03, "Coke", 42, 0, 50);
        newPricelist.addProduct(04, "Berries", 400, 99, 100);
        newPricelist.addProduct(05, "Cake", 499, 99, 7);
        newPricelist.nameChange(04, "Blueberries");
        Map<Integer, Product> testMap = new HashMap<>();
        testMap.put(01, new Product(01, "Pudding", new Price(48, 49), 4));
        testMap.put(02, new Product(02, "Frozen Pizza", new Price(229, 20), 1));
        testMap.put(03, new Product(03, "Coke", new Price(42, 00), 50));
        testMap.put(04, new Product(04, "Blueberries", new Price(400, 99), 100));
        testMap.put(05, new Product(05, "Cake", new Price(499, 99), 7));
        assertEquals(newPricelist.pricelist, testMap);
        log.log(Level.FINE, "Test on replacing a name of the product has finished");
    }

    @Test
    void testPriceChange() {
        log.log(Level.FINE, "Test on replacing a price of the product has started");
        PriceList newPricelist = new PriceList();
        newPricelist.addProduct(01, "Pudding", 48, 49, 4);
        newPricelist.addProduct(02, "Frozen Pizza", 229, 20, 1);
        newPricelist.addProduct(03, "Coke", 42, 0, 50);
        newPricelist.addProduct(04, "Berries", 400, 99, 100);
        newPricelist.addProduct(05, "Cake", 499, 99, 7);
        newPricelist.priceChange(04, 1000, 10);
        Map<Integer, Product> testMap = new HashMap<>();
        testMap.put(01, new Product(01, "Pudding", new Price(48, 49), 4));
        testMap.put(02, new Product(02, "Frozen Pizza", new Price(229, 20), 1));
        testMap.put(03, new Product(03, "Coke", new Price(42, 0), 50));
        testMap.put(04, new Product(04, "Berries", new Price(1000, 10), 100));
        testMap.put(05, new Product(05, "Cake", new Price(499, 99), 7));
        assertEquals(newPricelist.pricelist, testMap);
        log.log(Level.FINE, "Test on replacing a price of the product has finished");
    }

    @Test
    void testTotalCostExactProduct() {
        log.log(Level.FINE, "Test on counting the cost of all the items of one kind has started");
        PriceList newPricelist = new PriceList();
        newPricelist.addProduct(1, "mango", 10, 10, 1);
        newPricelist.addProduct(2, "cheese", 20, 20, 2);
        newPricelist.addProduct(3, "ice-cream", 30, 30, 3);
        assertEquals(4040, newPricelist.totalCostExactProduct(2));
        log.log(Level.FINE, "Test on counting the cost of all the items of one kind has finished");
    }

    @Test
    void testTotalCost() {
        log.log(Level.FINE, "Test on counting the cost of the whole purchase has started");
        PriceList moreProducts = new PriceList();
        moreProducts.addProduct(1, "mango", 10, 10, 1);
        moreProducts.addProduct(2, "cheese", 20, 20, 2);
        moreProducts.addProduct(3, "ice-cream", 30, 30, 3);
        assertEquals(14140, moreProducts.totalCost());
        log.log(Level.FINE, "Test on counting the cost of the whole purchase has finished");
    }

    @Test
    void testAddProductByString() {
        log.log(Level.FINE, "Test on adding a new product by the string received has started");
        PriceList newPricelist = new PriceList();
        Map<Integer, Product> testMap = new HashMap<>();
        testMap.put(001, new Product(001, "Popcorn",
                new Price(99, 99), 5));
        testMap.put(002, new Product(002, "Cookies",
                new Price(500, 00),10));
        newPricelist.addProductByString("001, Popcorn, 99.99, 5");
        newPricelist.addProductByString("002, Cookies, 500.00, 10");
        assertNotEquals(newPricelist, testMap);
        log.log(Level.FINE, "Test on adding a new product by the string received has finished");
    }
}



