package ru.spbstu.kspt.task1;

import java.util.HashMap;

public class PriceList {
    public HashMap<Integer, Product> PriceList = new HashMap<>();


    PriceList(HashMap pricelist) {
        PriceList = pricelist;
    }

    PriceList() {

    }

    public void addProduct(int code, Product product) {
        PriceList.put(code, product);
    }

    public void removeProduct(int code) {
        PriceList.remove(code);
    }

    public void changePrice(int code, int newRoublePrice, int newCopeikaPrice) {
        PriceList.get(code).roublePrice = newRoublePrice;
        PriceList.get(code).copeikaPrice = newCopeikaPrice;
    }

    public void changeName(int code, String newName) {
        PriceList.get(code).name = newName;

    }

    public double priceByCode(int code, int amount) {
        Product product = new Product();
        product = PriceList.get(code);
        return (product.getRoublePrice() + product.getCopeikaPrice() / 100.0) * amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PriceList priceList = (PriceList) o;

        return PriceList != null ? PriceList.equals(priceList.PriceList) : priceList.PriceList == null;
    }

    @Override
    public int hashCode() {
        return PriceList != null ? PriceList.hashCode() : 0;
    }

}

