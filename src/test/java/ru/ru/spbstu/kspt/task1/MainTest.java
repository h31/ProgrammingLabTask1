package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private static final Logger logger = LogManager.getLogger(MainTest.class);


    Product milk = new Product("Молоко", 1298, 6000);
    Product bread = new Product("Хлеб", 1283, 3600);
    Product cereal = new Product("Хлопья", 1376, 9900);
    Product tea = new Product("Чай", 1438, 13800);
    ArrayList<Product> listOfProducts = new ArrayList() {{
        add(milk);
        add(bread);
        add(cereal);
        add(tea);
    }};
    PriceList list = new PriceList(listOfProducts);
    PriceList testList = new PriceList();

    @Test
    public void addProduct() {
        testList.addProduct(milk);
        testList.addProduct(bread);
        testList.addProduct(cereal);
        testList.addProduct(tea);
        assertEquals(testList, list);
    }

    @Test
    public void removeProduct() {
        testList.addProduct(milk);
        testList.addProduct(bread);
        testList.addProduct(cereal);
        testList.addProduct(tea);
        testList.addProduct(tea);
        testList.removeProduct("Чай");
        assertEquals(testList, list);
    }

    @Test
    public void changePrice() {
        testList.addProduct(milk);
        testList.addProduct(bread);
        testList.addProduct(cereal);
        testList.addProduct(tea);
        testList.changePrice("Хлопья", 10000);
        testList.changePrice("Хлопья", 9900);
        assertEquals(testList, list);
    }

    @Test
    public void changeName() {
        testList.addProduct(milk);
        testList.addProduct(bread);
        testList.addProduct(cereal);
        testList.addProduct(tea);
        testList.changeName("Молоко", "Соевое молоко");
        testList.changeName("Соевое молоко", "Молоко");
        assertEquals(testList, list);
    }

    @Test
    public void priceByCode() {
        testList.addProduct(milk);
        testList.addProduct(bread);
        testList.addProduct(cereal);
        testList.addProduct(tea);
        testList.priceByCode(1283, 3600, 2);
        assertEquals(testList.priceByCode(1283, 3600, 2), 72);
    }

}
