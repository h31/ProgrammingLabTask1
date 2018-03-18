package ru.spbstu.kspt.task1;

public class Product {
    String name;
    int copeikaPrice;

    public Product(String name, int copeikaPrice) {
        this.name = name;
        this.copeikaPrice = copeikaPrice;
    }
    private Product(){}



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (copeikaPrice != product.copeikaPrice) return false;
        return name != null ? name.equals(product.name) : product.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + copeikaPrice;
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", copeikaPrice=" + copeikaPrice +
                '}';
    }

    public int getCopeikaPrice() {
        return copeikaPrice;
    }
    public String getName(){
        return this.name;
    }
}