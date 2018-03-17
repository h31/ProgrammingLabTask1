package ru.spbstu.kspt.task1;

import java.util.Arrays;

import static ru.spbstu.kspt.task1.CrossesOrNoughts.CROSS;
import static ru.spbstu.kspt.task1.CrossesOrNoughts.NOTHING;
import static ru.spbstu.kspt.task1.CrossesOrNoughts.NOUGHT;

public class Field {
    private int size;
    private CrossesOrNoughts[][] field;


    public Field(int size) {
        this.size = size;
        if (size <= 0){
            throw new IllegalArgumentException();
        }
        field = new CrossesOrNoughts[size][size];

        for (int height = 0; height < size; height++) {
            for (int width = 0; width < size; width++) {
                field[width][height] = NOTHING;
            }
        }
    }

    public void putValue(int width, int height, CrossesOrNoughts cell){
        field[width][height] = cell;
    }

    public void addCross(int width, int height){
        putValue(width, height, CROSS);
    }

    public void devastate(int width, int height){
        putValue(width, height, NOTHING);
    }

    public void addNought(int width, int height)
    {
        putValue(width, height, NOUGHT);
    }

    public int searchLongestSequenceHorizontally(int choice){
        int max;
        int sumNeedful;
        CrossesOrNoughts cell;
        if (choice == 0) {
            cell = NOUGHT;
        }
        else {
            cell = CROSS;
        }
        max = 0;
        sumNeedful = 0;
        for (int height = 0; height < size; height++) {
            for (int width = 0; width < size; width++) {
                if (field[width][height] == cell) {
                    sumNeedful += 1;
                    if (sumNeedful > max) {
                        max = sumNeedful;
                    }
                }
                else {
                    sumNeedful = 0;
                }
            }
            sumNeedful = 0;
        }
        return max;
    }

    public int searchLongestSequenceVertically(int choice){
        int max;
        int sumNeedful;
        CrossesOrNoughts cell;
        if (choice == 0) {
            cell = NOUGHT;
        }
        else {
            cell = CROSS;
        }
        max = 0;
        sumNeedful = 0;
        for (int width = 0; width < size; width++) {
            for (int height = 0; height < size; height++) {
                if (field[width][height] == cell) {
                    sumNeedful += 1;
                    if (sumNeedful > max) {
                        max = sumNeedful;
                    }
                }
                else {
                    sumNeedful = 0;
                }
            }
            sumNeedful = 0;
        }
        return max;
    }

    public int searchLongestSequenceDiagonally(int choice){
        int max;
        int max2;
        int i;
        int sumNeedful;
        CrossesOrNoughts cell;
        if (choice == 0) {
            cell = NOUGHT;
        }
        else {
            cell = CROSS;
        }
        max = 0;
        max2 = 0;
        sumNeedful = 0;
        for (int height = 0; height < size; height++) {
            for (int width = 0; width < size; width++) {
                i = 0;
                if (field[width][height] == cell) {
                    sumNeedful += 1;
                    if (max == 0) max = sumNeedful;
                    while ((i + width + 1) < size) {
                        i++;
                        if (field[width][height] == field[width + i][height + i]){
                            sumNeedful += 1;
                            if (sumNeedful > max) {
                                max = sumNeedful;
                            }
                        }
                        else {
                            sumNeedful = 0;
                        }
                    }
                }
                sumNeedful = 0;
            }
        }

        sumNeedful = 0;

        for (int height = 0; height < size; height++) {
            for (int width = size - 1; width == 0; width--) {
                i = 0;
                if (field[width][height] == cell) {
                    sumNeedful += 1;
                    if (max2 == 0) max2 = sumNeedful;
                    while ((i + height + 1) < size) {
                        i++;
                        if (field[width][height] == field[width - i][height + i]){
                            sumNeedful += 1;
                            if (sumNeedful > max) {
                                max2 = sumNeedful;
                            }
                        }
                        else {
                            sumNeedful = 0;
                        }
                    }
                }
            }
        }
        if (max2 > max) {
            return max2;
        } else {
            return max;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringField = new StringBuilder();
        for (int height = 0; height < size; height++) {
            for (int width = 0; width < size; width++) {
                switch (field[width][height]) {
                    case CROSS:
                        stringField.append("x");
                        break;
                    case NOTHING:
                        stringField.append(" ");
                        break;
                    case NOUGHT:
                        stringField.append("o");
                        break;
                }
                stringField.append('.');
            }
        }
        return stringField.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Field field1 = (Field) o;

        if (size != field1.size) return false;
        return Arrays.deepEquals(field, field1.field);
    }

    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + Arrays.deepHashCode(field);
        return result;
    }
}