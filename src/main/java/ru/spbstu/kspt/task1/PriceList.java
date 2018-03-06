package ru.spbstu.kspt.task1;

import java.util.HashMap;

import java.util.Map;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class
 */

public class PriceList implements PriceListInterface {
    private static Logger log = Logger.getLogger(PriceList.class.getName());

    public final Map<Integer, Product> pricelist = new HashMap<>();

    @Override
    public void addProduct(String name, int code, int priceRub, int priceCop, int quantity) {
        pricelist.put(code, new Product(name, code, priceRub, priceCop, quantity));
    }

    @Override
    public void removeProduct(int currentCode) {
        pricelist.remove(currentCode);
    }

    @Override
    public void priceChange(int currentCode, int currentPriceRub, int currentPriceCop) {
        if (pricelist.containsKey(currentCode)) {
            Product productChanged = new Product(pricelist.get(currentCode).getName(), currentCode, currentPriceRub,
                    currentPriceCop, pricelist.get(currentCode).getQuantity());
            pricelist.replace(currentCode, productChanged);
        }
    }

    @Override
    public void nameChange(int currentCode, String currentName) {
        if (pricelist.containsKey(currentCode)) {
            Product productChanged = new Product(currentName, currentCode, pricelist.get(currentCode).getPriceRub(),
                    pricelist.get(currentCode).getPriceCop(), pricelist.get(currentCode).getQuantity());
            pricelist.replace(currentCode, productChanged);
        }
    }

    @Override
    public int totalCostExactProduct(int currentCode) {
        return (pricelist.get(currentCode).getPriceRub() * 100 +
                pricelist.get(currentCode).getPriceCop()) *
                pricelist.get(currentCode).getQuantity();
    }

    @Override
    public int totalCost() {
        int sum = 0;
        for (Product p : pricelist.values()) {
            sum += totalCostExactProduct(p.getCode());
        }
        return sum;
    }

    @Override
    public void addProductByString(String currentProduct) {
        try {
            String[] strings = currentProduct.split(", ");
            String currentName = strings[0];
            int currentCode = Integer.parseInt(strings[1]);
            int currentPriceRub = Integer.parseInt(strings[2]);
            int currenPriceCop = Integer.parseInt(strings[3]);
            int currentQuantity = Integer.parseInt(strings[4]);
            addProduct(currentName, currentCode, currentPriceRub,
                    currenPriceCop, currentQuantity);
            log.log(Level.FINE, "Product {0} has just been added", new Product(currentName, currentCode,
                    currentPriceRub, currenPriceCop, currentQuantity));
        } catch (IllegalArgumentException ex) {
            log.log(Level.SEVERE, "Request is invalid", ex);
        }
        log.fine("done");
    }

    @Override
    public String totalCostExactProductInRubles(int currentCode) {
        int rubles = totalCostExactProduct(currentCode) / 100;
        int copecks = totalCostExactProduct(currentCode) % 100;
        return rubles + " rub " + copecks + " cop";
    }

    @Override
    public String totalCostInRubles() {
        int rubles = totalCost() / 100;
        int copecks = totalCost() % 100;
        return rubles + " rub " + copecks + " cop";
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


