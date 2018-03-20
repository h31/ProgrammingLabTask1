package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class MainTest {

    private static final Logger logger = LogManager.getLogger(MainTest.class);



    
    Map<Integer, Product> listOfProducts = new HashMap() {{
        put(1298, new Product("Молоко", 6000));
        put(1283, new Product("Хлеб", 3650));
        put(1376, new Product("Хлопья", 9900));
        put(1438, new Product("Чай", 13872));
    }};
    PriceList list = new PriceList(listOfProducts);

    private static PriceList createPricelist(){
        PriceList testList = new PriceList();
        testList.addProduct(1298, new Product ("Молоко", 6000));
        testList.addProduct(1283, new Product("Хлеб", 3650));
        testList.addProduct(1376, new Product("Хлопья", 9900));
        testList.addProduct(1438, new Product("Чай", 13872));
        return testList;
    }

    @Test
    public void addProductCorrect() {
        PriceList testList = createPricelist();
        testList.addProduct(1895, new Product("Сок", 7800));
        testList.addProduct(2007, new Product("Шоколад", 12499));
        assertEquals(6, testList.getPriceList().size());
        assertThrows(IllegalArgumentException.class, () -> testList.addProduct(1438, new Product("Сок", 7800)));
    }


    @Test
    public void removeProduct() {

        PriceList testList = createPricelist();
        testList.addProduct(1439, new Product("Чай", 13872));
        testList.removeProduct(1439);
        assertEquals(4, testList.getPriceList().size());
        assertThrows(IllegalArgumentException.class, () -> testList.removeProduct(1000));
    }


    @Test
    public void changePrice() {
        PriceList testList = createPricelist();
        testList.changePrice(1376, 10000);
        testList.changePrice(1376, 9900);
        assertEquals(testList, list);
        assertThrows(IllegalArgumentException.class, () -> testList.changePrice(1283, -6500));
    }

    @Test
    public void changeName() {
        PriceList testList = createPricelist();
        testList.changeName(1298, "Соевое молоко");
        assertEquals(testList.getPriceList().get(1298).name, "Соевое молоко");
        assertThrows(IllegalArgumentException.class, () -> testList.changeName(1376, "Хлеб"));
    }

    @Test
    public void priceByCode() {
        PriceList testList = createPricelist();
        assertEquals(testList.priceByCode(1283, 2), 7300);
        assertThrows(IllegalArgumentException.class, () -> testList.priceByCode(1283, -5));
    }

}
