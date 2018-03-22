package ru.spbstu.kspt.task1;

public interface PriceListInterface {
    void addProduct(int code, Product product);

    void removeProduct(int code);

    void changePrice (int code, int newCopeikaPrice);

    void changeName (int code, String newName);

    int priceByCode (int code, int amount);
}
