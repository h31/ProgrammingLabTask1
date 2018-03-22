package ru.spbstu.kspt.task1;

public class Product {
    String name;
    int copeikaPrice;
    int protein;
    int fat;
    int carbohydrates;
    int allowedAmount;

    private Product() {
    }

    public int getCopeikaPrice() {
        return copeikaPrice;
    }

    public String getName() {
        return this.name;
    }

    public int getProtein(){
        return this.protein;
    }

    public int getFat(){
        return this.fat;
    }

    public int getCarbohydrates(){
        return this.carbohydrates;
    }

    public int getAllowedAmount(){
        return this.allowedAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (copeikaPrice != product.copeikaPrice) return false;
        if (protein != product.protein) return false;
        if (fat != product.fat) return false;
        if (carbohydrates != product.carbohydrates) return false;
        if (allowedAmount != product.allowedAmount) return false;
        return name != null ? name.equals(product.name) : product.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + copeikaPrice;
        result = 31 * result + protein;
        result = 31 * result + fat;
        result = 31 * result + carbohydrates;
        result = 31 * result + allowedAmount;
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", copeikaPrice=" + copeikaPrice +
                ", protein=" + protein +
                ", fat=" + fat +
                ", carbohydrates=" + carbohydrates +
                ", allowedAmount=" + allowedAmount +
                '}';
    }
}