package ru.spbstu.kspt.task1;

public interface PriceListInterface {
    void addProduct(String name, int code, int priceRub, int priceCop, int quantity);

    void removeProduct(int currentCode);

    void priceChange(int currentCode, int currentPriceRub, int currentPriceCop);

    void nameChange(int currentCode, String currentName);

    int totalCostExactProduct(int currentCode);

    int totalCost();
}
