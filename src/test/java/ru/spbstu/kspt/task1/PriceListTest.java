package ru.spbstu.kspt.task1;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;


public class PriceListTest {
    private static final Logger logger = LogManager.getLogger(PriceListTest.class);

    @Test
    void testAddProduct() {
        logger.info("Test on adding a product has started");
        PriceList newPricelist = new PriceList();
        Map<Integer, Product> testMap = new HashMap<>();
        testMap.put(001, new Product("Popcorn", 001, 99, 99, 5));
        testMap.put(002, new Product("Cookies", 002,
                500, 00, 10));
        newPricelist.addProduct("Popcorn", 001, 98, 99, 5);
        newPricelist.addProduct("Cookies", 002,
                550, 00, 10);
        assertNotEquals(newPricelist.pricelist, testMap);
        logger.info("Test on adding a product has finished");
    }

    @Test
    void testRemoveProduct() {
        logger.info("Test on removing a product has started");
        PriceList newPricelist = new PriceList();
        newPricelist.addProduct("Pudding", 01, 48, 49, 4);
        newPricelist.addProduct("Frozen Pizza", 02, 229, 20, 1);
        newPricelist.addProduct("Coke", 03, 42, 0, 50);
        newPricelist.addProduct("Berries", 04, 400, 99, 100);
        newPricelist.removeProduct(03);
        newPricelist.removeProduct(04);
        assertFalse(newPricelist.pricelist.containsKey(03));
        assertFalse(newPricelist.pricelist.containsKey(04));
        logger.info("Test on removing a product has finished");
    }

    @Test
    void testNameChange() {
        logger.info("Test on replacing a name of the product has started");
        PriceList newPricelist = new PriceList();
        newPricelist.addProduct("Pudding", 01, 48, 49, 4);
        newPricelist.addProduct("Frozen Pizza", 02, 229, 20, 1);
        newPricelist.addProduct("Coke", 03, 42, 0, 50);
        newPricelist.addProduct("Berries", 04, 400, 99, 100);
        newPricelist.addProduct("Cake", 05, 499, 99, 7);
        newPricelist.nameChange(04, "Blueberries");
        Map<Integer, Product> testMap = new HashMap<>();
        testMap.put(01, new Product("Pudding", 01, 48, 49, 4));
        testMap.put(02, new Product("Frozen Pizza", 02, 229, 20, 1));
        testMap.put(03, new Product("Coke", 03, 42, 0, 50));
        testMap.put(04, new Product("Blueberries", 04, 400, 99, 100));
        testMap.put(05, new Product("Cake", 05, 499, 99, 7));
        assertEquals(newPricelist.pricelist, testMap);
        logger.info("Test on replacing a name of the product has finished");
    }

    @Test
    void testPriceChange() {
        logger.info("Test on replacing a price of the product has started");
        PriceList newPricelist = new PriceList();
        newPricelist.addProduct("Pudding", 01, 48, 49, 4);
        newPricelist.addProduct("Frozen Pizza", 02, 229, 20, 1);
        newPricelist.addProduct("Coke", 03, 42, 0, 50);
        newPricelist.addProduct("Berries", 04, 400, 99, 100);
        newPricelist.addProduct("Cake", 05, 499, 99, 7);
        newPricelist.priceChange(04, 1000, 10);
        Map<Integer, Product> testMap = new HashMap<>();
        testMap.put(01, new Product("Pudding", 01, 48, 49, 4));
        testMap.put(02, new Product("Frozen Pizza", 02, 229, 20, 1));
        testMap.put(03, new Product("Coke", 03, 42, 0, 50));
        testMap.put(04, new Product("Berries", 04, 1000, 10, 100));
        testMap.put(05, new Product("Cake", 05, 499, 99, 7));
        assertEquals(newPricelist.pricelist, testMap);
        logger.info("Test on replacing a price of the product has finished");
    }

    @Test
    void testTotalCostExactProduct() {
        logger.info("Test on counting the cost of all the items of one kind has started");
        PriceList newPricelist = new PriceList();
        newPricelist.addProduct("mango", 1, 10, 10, 1);
        newPricelist.addProduct("cheese", 2, 20, 20, 2);
        newPricelist.addProduct("ice-cream", 3, 30, 30, 3);
        assertEquals(4040, newPricelist.totalCostExactProduct(2));
        logger.info("Test on counting the cost of all the items of one kind has finished");
    }

    @Test
    void testTotalCost() {
        logger.info("Test on counting the cost of the whole purchase has started");
        PriceList moreProducts = new PriceList();
        moreProducts.addProduct("mango", 1, 10, 10, 1);
        moreProducts.addProduct("cheese", 2, 20, 20, 2);
        moreProducts.addProduct("ice-cream", 3, 30, 30, 3);
        assertEquals(14140, moreProducts.totalCost());
        logger.info("Test on counting the cost of the whole purchase has finished");
    }

    @Test
    void testAddProductByString() {
        logger.info("Test on adding a new product by the string received has started");
        PriceList newPricelist = new PriceList();
        Map<Integer, Product> testMap = new HashMap<>();
        testMap.put(001, new Product("Popcorn", 001, 99, 99, 5));
        testMap.put(002, new Product("Cookies", 002,
                500, 00, 10));
        newPricelist.addProductByString("Popcorn, 001, 99, 99, 5");
        newPricelist.addProductByString("Cookies, 002, 500, 00, 10");
        assertNotEquals(newPricelist, testMap);
        logger.info("Test on adding a new product by the string received has finished");
    }

    @Test
    void testTotalCostExactProductInRubles() {
        logger.info("Test on counting the cost of all the items of one kind in rubles has started");
        PriceList newPricelist = new PriceList();
        newPricelist.addProduct("mango", 1, 10, 10, 1);
        newPricelist.addProduct("cheese", 2, 20, 20, 2);
        newPricelist.addProduct("ice-cream", 3, 30, 30, 3);
        assertEquals("40 rub 40 cop", newPricelist.totalCostExactProductInRubles(2));
        logger.info("Test on counting the cost of all the items of one kind in rubles has finished");
    }

    @Test
    void testTotalCostInRub() {
        logger.info("Test on counting the cost of the whole purchase has started");
        PriceList newPricelist = new PriceList();
        newPricelist.addProduct("mango", 1, 10, 10, 1);
        newPricelist.addProduct("cheese", 2, 20, 20, 2);
        newPricelist.addProduct("ice-cream", 3, 30, 30, 3);
        assertEquals("141 rub 40 cop", newPricelist.totalCostInRubles());
        logger.info("Test on counting the cost of the whole purchase has finished");
    }
}



