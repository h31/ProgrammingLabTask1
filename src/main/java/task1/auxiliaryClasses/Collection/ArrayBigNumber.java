package task1.auxiliaryClasses.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.List;

public class ArrayBigNumber implements CollectionBigNumber<Integer> {

    /**
     * This collection is a variant of storing a large number of blocks,
     * in other words, translating a large number into another notation
     * system with the base notation.
     * The maximum capacity of the unit is indicated in notation (capacity + 1).
     * Proceeding from this, the maximum length of one block is calculated,
     * as well as the storage for the blocks.
     */

    private final int notation = 1000000000;
    // The maximum capacity of the unit is indicated in notation (capacity + 1).
    private final int lenOneNum = (int) Math.ceil(Math.log10(notation + 0.5) - 1);
    // The maximum length of one block
    private List<Integer> storage = new ArrayList<>();
    private int length = 0;
    // Number of digits in number
    private int size;
    // Number of blocks
    private int flag;
    // Number of digits in the last block

    public ArrayBigNumber(String number) {
        this.add(number);
    }

    public ArrayBigNumber(int number) {
        this.add(number);
    }

    public ArrayBigNumber() {
    }

    @Override
    public void add(String added) {
        int addedLength = added.length();
        this.length = addedLength;
        for (int i = 0; i < addedLength; i += lenOneNum) {
            Integer add =
                    Integer.valueOf(added.substring(i, (addedLength > i + lenOneNum) ? i + lenOneNum : addedLength));
            if (i + lenOneNum >= addedLength) {
                flag = (i + lenOneNum) - addedLength + 1;
            }
            storage.add(add);
        }
        this.size = this.storage.size();
    }

    public void add(int added) {
        this.add(String.valueOf(added));
    }

    @Override
    public Integer get(int index) {
        return this.storage.get(index);
    }

    @Override
    public void set(int index, int object) {
        if (this.storage.get(index) != null && object < this.notation && object >= 0) {
            this.storage.set(index, object);
        }
    }

    @Override
    public void remove(int index) {
        if (this.storage.get(index) != null) {
            this.storage.remove(index);
        }
    }

    @Override
    public int length() {
        return this.length;
    }

    public int columnBlocks() {
        return size;
    }

    public void reverse() {
        List<Integer> buff = new ArrayList<>();
        List<Integer> storage = this.storage;
        for (int i = this.size - 1; i >= 0; i--) {
            buff.add(storage.get(i));
        }
        this.storage = buff;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void asCollection(Integer... values) {
        this.add(Arrays.toString(values));
    }

    public int getNotation() {
        return notation;
    }

    public List<Integer> getStorage() {
        return storage;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getLenOneNum() {
        return lenOneNum;
    }

    @Override
    public String toString() {
        StringBuilder answer = new StringBuilder();
        List<Integer> bufStorage = this.storage;
        for (int i = 0; i < bufStorage.size(); i++) {
            Integer element = bufStorage.get(i);
            int lenElement = (int) Math.ceil(Math.log10(element + 0.5) - 1);
            try {
                if (lenElement < lenOneNum - 1) {
                    if (element == 0) lenElement++;
                    String pattern = "%0" + (lenOneNum - lenElement - (i == bufStorage.size() - 1 ? flag : 1)) + "d";
                    answer.append(pattern.contains("00") ? "" : String.format(pattern, 0));
                }
            } catch (IllegalFormatException ignored) {
            }
            answer.append(element);
        }
        return answer.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj.getClass() == this.getClass() && this.storage.equals(((ArrayBigNumber) obj).storage));
    }

    @Override
    public int hashCode() {
        return this.size * this.lenOneNum * this.storage.hashCode();
    }
}
