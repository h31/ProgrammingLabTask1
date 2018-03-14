package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private static final Logger logger = LogManager.getLogger(MainTest.class);


    Product milk = new Product("Молоко", 60, 0);
    Product bread = new Product("Хлеб", 36, 50);
    Product cereal = new Product("Хлопья", 99, 99);
    Product tea = new Product("Чай", 138, 72);
    HashMap<Integer, Product> listOfProducts = new HashMap() {{
        put(1298, milk);
        put(1283, bread);
        put(1376, cereal);
        put(1438, tea);
    }};
    PriceList list = new PriceList(listOfProducts);
    PriceList testList = new PriceList();

    @Test
    public void addProduct() {
        testList.addProduct(1298, milk);
        testList.addProduct(1283, bread);
        testList.addProduct(1376, cereal);
        testList.addProduct(1438, tea);
        assertEquals(testList, list);
    }

    @Test
    public void removeProduct() {
        testList.addProduct(1298, milk);
        testList.addProduct(1283, bread);
        testList.addProduct(1376, cereal);
        testList.addProduct(1438, tea);
        testList.addProduct(1439, tea);
        testList.removeProduct(1439);
        assertEquals(testList, list);
    }

    @Test
    public void changePrice() {
        testList.addProduct(1298, milk);
        testList.addProduct(1283, bread);
        testList.addProduct(1376, cereal);
        testList.addProduct(1438, tea);
        testList.changePrice(1376, 100, 00);
        testList.changePrice(1376, 99, 99);
        assertEquals(testList, list);
    }

    @Test
    public void changeName() {
        testList.addProduct(1298, milk);
        testList.addProduct(1283, bread);
        testList.addProduct(1376, cereal);
        testList.addProduct(1438, tea);
        testList.changeName(1298, "Соевое молоко");
        testList.changeName(1298, "Молоко");
        assertEquals(testList, list);
    }

    @Test
    public void priceByCode() {
        testList.addProduct(1298, milk);
        testList.addProduct(1283, bread);
        testList.addProduct(1376, cereal);
        testList.addProduct(1438, tea);
        assertEquals(testList.priceByCode(1283, 2), 73.0);
    }

}
