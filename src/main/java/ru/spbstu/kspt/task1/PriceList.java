package ru.spbstu.kspt.task1;

import java.util.ArrayList;

public class PriceList {
    public ArrayList<Product> PriceList = new ArrayList<>();

    PriceList(ArrayList list){
        PriceList = list;
    }
    PriceList(){

    }

    public void addProduct(Product product) {
       // Product product = new Product(name, code, price);
        PriceList.add(product);
    }

    public void removeProduct(String name) {
        for (int i = 0; i < PriceList.size(); i++)
            if (PriceList.get(i).name.equals(name)) PriceList.remove(i);
    }

    public void changePrice(String name, int newPrice) {
        for (int i = 0; i < PriceList.size(); i++)
            if (PriceList.get(i).name.equals(name)) PriceList.get(i).price = newPrice;
    }

    public void changeName(String name, String newName) {
        for (int i = 0; i < PriceList.size(); i++)
            if (PriceList.get(i).name.equals(name)) PriceList.get(i).name = newName;

    }

    public int priceByCode(int code, int price, int amount) {
        int result = 0;
        for (int i = 0; i < PriceList.size(); i++)
            if (PriceList.get(i).code == code) {
                result = PriceList.get(i).price * amount / 100;
            }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        PriceList priceList = (PriceList) obj;
        for (int i = 0; i < PriceList.size(); i++) {
            if (PriceList.get(i) != priceList.PriceList.get(i)) return false;
        }
        return true;
    }
}

