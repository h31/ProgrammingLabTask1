package ru.spbstu.kspt.task1;

import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Integer.parseInt;


class Price {
    private static Logger log = Logger.getLogger(Product.class.getName());

    private int priceRub, priceCop;

    Price(int priceRub, int priceCop) {
        if (priceCop >= 100 || priceCop <= -1 || priceRub < 0) {
            throw new IllegalArgumentException("Request is invalid");
        }
        try {
            this.priceRub = priceRub;
            this.priceCop = priceCop;
        } catch (IllegalArgumentException ex) {
            log.log(Level.SEVERE, "Price was {0}, expected 0 <= priceCop < 100", priceCop);
            throw ex;
        }
    }

    int getPriceRub() {
        return priceRub;
    }

    int getPriceCop() {
        return priceCop;
    }

    void setPrice(int priceRub, int priceCop) {
        try {
            this.priceRub = priceRub;
            this.priceCop = priceCop;
        } catch (IllegalArgumentException ex) {
            log.log(Level.SEVERE, "Arguments are inappropriate.", ex);
            throw ex;
        }
    }

    int totalCostExactProduct() {
        return priceRub * 100 + priceCop;
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
