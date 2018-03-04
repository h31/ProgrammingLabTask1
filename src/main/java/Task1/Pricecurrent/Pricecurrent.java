package Task1.Pricecurrent;

import java.util.ArrayList;

public class Pricecurrent {
    private String nameOfMerch;
    private int codeOfMerch;
    private double priceOfMerch;

    Pricecurrent(String nameOfMerch, int codeOfMerch, double priceOfMerch) {
        this.nameOfMerch = nameOfMerch;
        this.codeOfMerch = codeOfMerch;
        this.priceOfMerch = priceOfMerch;
    }

    ArrayList<Pricecurrent> listOfMerch = new ArrayList<Pricecurrent>();

    public void addMerch() {
        Pricecurrent merch = new Pricecurrent(nameOfMerch, codeOfMerch, priceOfMerch);
        listOfMerch.add(merch);
    }

    public void removeMerch() {
        listOfMerch.remove(nameOfMerch)
    }

    public void changePrice(String nameOfMerch, double newPrice) {
        for (int i = 0; i <= listOfMerch.size(); i++)
            if (listOfMerch.get(i).nameOfMerch.equals(nameOfMerch)) listOfMerch.get(i).priceOfMerch = newPrice;
    }

    public void changeName(String nameOfMerch, String newName) {
        for (int i = 0; i <= listOfMerch.size(); i++)
            if (listOfMerch.get(i).nameOfMerch.equals(nameOfMerch)) listOfMerch.get(i).nameOfMerch = newName;

    }

    public double priceByCode(int codeOfMerch, double priceOfMerch, int amountOfMerch) {
        double result = 0.0;
        for (int i = 0; i <= listOfMerch.size(); i++)
            if (listOfMerch.get(i).codeOfMerch == codeOfMerch) {
                result = listOfMerch.get(i).priceOfMerch * amountOfMerch;
            }
        return result;
    }
}
