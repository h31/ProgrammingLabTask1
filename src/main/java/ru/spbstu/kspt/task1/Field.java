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

    public int searchLongestSequence(boolean choice, CrossesOrNoughts cell) {
        int max = 0;
        int sum = 0;
        for (int height = 0; height < size; height++) {
            for (int width = 0; width < size; width++) {
                if (choice) {
                    if (field[height][width] == cell) {
                        sum += 1;
                        if (sum > max) {
                            max = sum;
                        }
                    }
                    else {
                        sum = 0;
                    }
                }
                else {
                    if (field[width][height] == cell) {
                        sum += 1;
                        if (sum > max) {
                            max = sum;
                        }
                    }
                    else {
                        sum = 0;
                    }
                }
            }
            sum = 0;
        }
        return max;
    }

    public int searchLongestSequenceHorizontallyNought() {
        return searchLongestSequence(false, NOUGHT);
    }

    public int searchLongestSequenceHorizontallyCross() {
        return searchLongestSequence(false, CROSS);
    }

    public int searchLongestSequenceVerticallyCross() {
        return searchLongestSequence(true, CROSS);
    }

    public int searchLongestSequenceVerticallyNought() {
        return searchLongestSequence(true, NOUGHT);
    }

    public int searchLongestSequenceDiagonallyNought(){
        return searchLongestSequenceDiagonally(NOUGHT);
    }

    public int searchLongestSequenceDiagonallyCross(){
        return searchLongestSequenceDiagonally(CROSS);
    }

    public int searchLongestSequenceDiagonally(CrossesOrNoughts cell){
        int max = 0;
        int max2 = 0;
        int i;
        int sum = 0;
        for (int height = 0; height < size; height++) {
            for (int width = 0; width < size; width++) {
                i = 0;
                if (field[width][height] == cell) {
                    sum += 1;
                    if (max == 0) max = sum;
                    while ((i + width + 1) < size && (i + height + 1) < size) {
                        i++;
                        if (field[width][height] == field[width + i][height + i]){
                            sum += 1;
                            if (sum > max) {
                                max = sum;
                            }
                        }
                        else {
                            sum = 0;
                        }
                    }
                }
            }
            sum = 0;
            int width = size;
            while (width >= 1) {
                width--;
                i = 0;
                if (field[width][height] == cell) {
                    sum += 1;
                    if (max2 == 0) max2 = sum;
                    while ((width - i > 0) && (i + height + 1 < size)) {
                        i++;
                        if (field[width][height] == field[width - i][height + i]){
                            sum += 1;
                            if (sum > max2) {
                                max2 = sum;
                            }
                        }
                        else {
                            sum = 0;
                        }
                    }
                }
            }
            sum = 0;
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