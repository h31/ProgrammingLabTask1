package ru.spbstu.kspt.task1;

import java.util.logging.Level;
import java.util.logging.Logger;


class Price {
    private static Logger log = Logger.getLogger(Product.class.getName());

    private int priceRub, priceCop;

    Price(int priceRub, int priceCop) {
        if (priceCop >= 100 || priceCop <= -1) {
            throw new IllegalArgumentException("Request is invalid");
        }
        try {
            this.priceRub = priceRub;
            this.priceCop = priceCop;
        } catch (IllegalArgumentException ex) {
            log.log(Level.SEVERE, "Arguments are inappropriate.", ex);
        }
    }

    int getPriceRub() {
        return priceRub;
    }

    int getPriceCop() {
        return priceCop;
    }

    public void setPriceRub(int priceRub) {
        this.priceRub = priceRub;
    }

    public void setPriceCop(int priceCop) {
        this.priceCop = priceCop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;

        Price price = (Price) o;

        if (getPriceRub() != price.getPriceRub()) return false;
        return getPriceCop() == price.getPriceCop();
    }

    @Override
    public int hashCode() {
        int result = getPriceRub();
        result = 31 * result + getPriceCop();
        return result;
    }
}
