package ru.spbstu.kspt.task1;

interface PriceListInterface {
    void addProduct(int code, String name, int priceRub, int priceCop, int quantity);

    void removeProduct(int currentCode);

    void priceChange(int currentCode, int newPriceRub, int newPriceCop);

    void nameChange(int currentCode, String currentName);

    int totalCostExactProduct(int currentCode);

    int totalCost();

    void addProductByString(String currentProduct);
}
