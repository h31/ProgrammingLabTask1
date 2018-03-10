package ru.spbstu.kspt.task1;

import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.in;

class Product {
    private static Logger log = Logger.getLogger(Product.class.getName());

    private String name;
    private int code;
    private Price price;
    private int quantity;

    Product(int code, String name, Price price, int quantity) {
        try {
            this.name = name;
            this.code = code;
            this.price = price;
            this.quantity = quantity;
            log.log(Level.INFO, "New item of type 'product' is created: {0}", this);
        } catch (IllegalArgumentException ex) {
            log.log(Level.SEVERE, "Arguments are inappropriate.", ex);
        }
        log.fine("done");
    }

    int getCode() {
        return code;
    }

    String getName() {
        return name;
    }

    Price getPrice() {
        return price;
    }

    int getQuantity() {
        return quantity;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product Code: " + code + ", Product Name: " + name + ", Product Price: " + price.getPriceRub() + "rub, "
                + price.getPriceCop() + "cop, Number of Items: " + quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (code != product.code) return false;
        if (!price.equals(product.price)) return false;
        if (quantity != product.quantity) return false;
        return name != null ? name.equals(product.name) : product.name == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getCode();
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + getQuantity();
        return result;
    }
}
