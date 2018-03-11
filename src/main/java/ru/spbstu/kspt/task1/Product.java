package ru.spbstu.kspt.task1;

public class Product {
    String name;
    int code;
    int price;

    public Product(String name, int code, int price) {
        this.name = name;
        this.code = code;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        Product product = (Product) obj;
        if (name != product.name || code != product.code || price != product.price) return false;
        return true;
    }
}