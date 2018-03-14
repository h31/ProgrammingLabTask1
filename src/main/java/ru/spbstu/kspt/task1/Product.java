package ru.spbstu.kspt.task1;

public class Product {
    String name;
    int roublePrice;
    int copeikaPrice;

    public Product(String name, int roublePrice, int copeikaPrice) {
        this.name = name;
        this.roublePrice = roublePrice;
        this.copeikaPrice = copeikaPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (roublePrice != product.roublePrice) return false;
        if (copeikaPrice != product.copeikaPrice) return false;
        return name != null ? name.equals(product.name) : product.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + roublePrice;
        result = 31 * result + copeikaPrice;
        return result;
    }
}