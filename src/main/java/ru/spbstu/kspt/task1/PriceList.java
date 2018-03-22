package ru.spbstu.kspt.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PriceList {
    private Map<Integer, Product> PriceList = new HashMap<Integer, Product>();


    public PriceList(Map pricelist) {
        PriceList = pricelist;
    }

    public PriceList() {

    }

    public Map<Integer, Product> getPriceList() {
        return PriceList;
    }

    public void addProduct(int code, Product product) {
        if (PriceList.containsKey(code)) {
            throw new IllegalArgumentException("Товар с таким кодом уже существует");
        } else
            PriceList.put(code, product);
    }

    public void removeProduct(int code) {
        if (!PriceList.containsKey(code)) {
            throw new IllegalArgumentException("Товара с таким кодом не существует");
        } else
            PriceList.remove(code);
    }

    public void changePrice(int code, int newCopeikaPrice) {
        if (newCopeikaPrice <= 0 || !PriceList.containsKey(code)) {
            throw new IllegalArgumentException("Неверный ввод цены или кода продукта");
        } else {
            PriceList.get(code).copeikaPrice = newCopeikaPrice;
        }
    }


    public void changeName(int code, String newName) {
        for (Map.Entry<Integer, Product> entry : PriceList.entrySet()) {
            if (entry.getValue().getName().equals(newName)) {
                throw new IllegalArgumentException("Продукт с таким названием уже существует под другим кодом");
            }
        }
        PriceList.get(code).name = newName;
    }

    public int priceByCode(int code, int amount) {
        if (amount >= 0 && PriceList.containsKey(code)) {
            return PriceList.get(code).getCopeikaPrice() * amount;
        } else {
            throw new IllegalArgumentException("Отрицательное число товаров");
        }
    }

    public void getAmountofFood (){
        ArrayList<Map.Entry<Integer, Product>> newListOfProduct = new ArrayList<Map.Entry<Integer, Product>>(PriceList.entrySet());

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

    @Override
    public String toString() {
        return "PriceList{" +
                "PriceList=" + PriceList +
                '}';
    }

}