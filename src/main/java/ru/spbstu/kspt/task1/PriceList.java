package ru.spbstu.kspt.task1;

import java.util.ArrayList;

public class PriceList {
    private ArrayList<Product> listOfProducts;

    public class Product {
        String name;
        int code;
        int price;

        Product(String name, int code, int price) {
            this.name = name;
            this.code = code;
            this.price = price;
        }
    }

    public void addProduct(String name, int code, int price) {
        Product product = new Product(name, code, price);
        listOfProducts.add(product);
    }

    public void removeProduct(String name) {
        for (int i = 0; i <= listOfProducts.size(); i++)
            if (listOfProducts.get(i).name.equals(name)) listOfProducts.remove(i);
    }

    public void changePrice(String name, int newPrice) {
        for (int i = 0; i <= listOfProducts.size(); i++)
            if (listOfProducts.get(i).name.equals(name)) listOfProducts.get(i).price = newPrice;
    }

    public void changeName(String name, String newName) {
        for (int i = 0; i <= listOfProducts.size(); i++)
            if (listOfProducts.get(i).name.equals(name)) listOfProducts.get(i).name = newName;

    }

    public int priceByCode(int code, int price, int amount) {
        int result = 0;
        for (int i = 0; i <= listOfProducts.size(); i++)
            if (listOfProducts.get(i).code == code) {
                result = listOfProducts.get(i).price * amount / 100;
            }
        return result;
    }
}
