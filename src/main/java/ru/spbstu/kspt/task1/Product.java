package ru.spbstu.kspt.task1;


public class Product {

    private String name;
    private int code;
    private int priceRub, priceCop;
    private int quantity;

    public Product(String name, int code, int PriceRub, int PriceCop, int quantity) {
        try {
            this.name = name;
            this.code = code;
            this.priceRub = priceRub;
            this.priceCop = priceCop;
            this.quantity = quantity;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public int getPriceRub() {
        return priceRub;
    }

    public int getPriceCop() {
        return priceCop;
    }

    public int getQuantity() {
        return quantity;
    }

    private int wholeCostInCop = (priceRub * 100 + priceCop) * quantity;

    public int getCostRub() {
        return wholeCostInCop / 100;
    }

    public int getCostCop() {
        return wholeCostInCop % 100;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setPriceRub(int priceRub) {
        this.priceRub = priceRub;
    }

    public void setPriceCop(int priceCop) {
        this.priceCop = priceCop;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product Name: " + name + "; Product Code: " + code + "; Product Price: " + priceRub +
                " rub, " + priceCop + "cop; Number of Items: " + quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (code != product.code) return false;
        if (priceRub != product.priceRub) return false;
        if (priceCop != product.priceCop) return false;
        if (quantity != product.quantity) return false;
        return name != null ? name.equals(product.name) : product.name == null;
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getCode();
        result = 31 * result + getPriceRub();
        result = 31 * result + getPriceCop();
        result = 31 * result + getQuantity();
        result = 31 * result + wholeCostInCop;
        return result;
    }
}
