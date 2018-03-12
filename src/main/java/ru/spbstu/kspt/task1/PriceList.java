package ru.spbstu.kspt.task1;

import java.util.HashMap;

import java.util.Map;

import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Integer.parseInt;

/**
 * Main class
 */

class PriceList implements PriceListInterface {
    private static Logger log = Logger.getLogger(PriceList.class.getName());

    final Map<Integer, Product> pricelist = new HashMap<>();

    @Override
    public void addProduct(int code, String name, int priceRub, int priceCop, int quantity) {
        try {
            pricelist.put(code, new Product(code, name, new Price(priceRub, priceCop), quantity));
        } catch (IllegalArgumentException ex) {
            log.log(Level.SEVERE, "Request is invalid", ex);
            throw ex;
        }
    }

    @Override
    public void removeProduct(int code) {
        try {
            pricelist.remove(code);
        } catch (IllegalArgumentException ex) {
            log.log(Level.SEVERE, "Request is invalid", ex);
            throw ex;
        }
    }

    @Override
    public void priceChange(int code, int newPriceRub, int newPriceCop) {
        try {
            Product productChanged = new Product(code, pricelist.get(code).getName(),
                    new Price(newPriceRub, newPriceCop), pricelist.get(code).getQuantity());
            pricelist.replace(code, productChanged);
        } catch (IllegalArgumentException ex) {
            log.log(Level.SEVERE, "Request is invalid", ex);
            throw ex;
        }
    }

    @Override
    public void nameChange(int code, String newName) {
        try {
            Product productChanged = new Product(code, newName, pricelist.get(code).getPrice(),
                    pricelist.get(code).getQuantity());
            pricelist.replace(code, productChanged);
        } catch (IllegalArgumentException ex) {
            log.log(Level.SEVERE, "Request is invalid", ex);
            throw ex;
        }
    }

    @Override
    public int totalCostExactProduct(int code) {
        try {
            return pricelist.get(code).getPrice().totalCostExactProduct() * pricelist.get(code).getQuantity();
        } catch (IllegalArgumentException ex) {
            log.log(Level.SEVERE, "Request is invalid", ex);
            throw ex;
        }
    }

    @Override
    public int totalCost() {
        int sum = 0;
        for (int i : pricelist.keySet()) {
            sum += totalCostExactProduct(i);
        }
        return sum;
    }

    Price priceFromString(String price) {
        if (price.split(".").length != 2) {
            throw new IllegalArgumentException("Request is invalid");
        }
        try {
            return new Price(parseInt(price.split(".")[0]), parseInt(price.split(".")[1]));
        } catch (IllegalArgumentException ex) {
            log.log(Level.SEVERE, "Request is invalid", ex);
            throw ex;
        }
    }


    @Override
    public void addProductByString(String product) {
        try {
            String[] strings = product.split(", ");
            if (strings.length != 4) {
                throw new IllegalArgumentException("Request is invalid");
            }
            int currentCode = Integer.parseInt(strings[0]);
            String currentName = strings[1];
            Price currentPrice = priceFromString(strings[2]);
            int currentQuantity = Integer.parseInt(strings[3]);
            addProduct(currentCode, currentName, currentPrice.getPriceRub(),
                    currentPrice.getPriceCop(), currentQuantity);
            log.log(Level.FINE, "Product {0} has just been added", new Product(currentCode, currentName,
                    currentPrice, currentQuantity));
        } catch (IllegalArgumentException ex) {
            log.log(Level.SEVERE, "Request is invalid", ex);
            throw ex;
        }
        log.fine("done");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PriceList)) return false;
        PriceList priceList = (PriceList) o;
        return pricelist.equals(priceList.pricelist);
    }

    @Override
    public int hashCode() {
        return pricelist != null ? pricelist.hashCode() : 0;
    }
}


