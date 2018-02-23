package ru.spbstu.kspt.task1;

import java.util.ArrayList;
import java.util.Arrays;

public class TicTacField {
    private final int size;
    private Cell[][] mField;

    public TicTacField(int size) {
        if (size <= 0) throw new IllegalArgumentException("size can't be <= 0");

        this.size = size;
        mField = new Cell[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                mField[row][col] = new Cell(row, col);
            }
        }
    }

    public void addCross(int row, int col) {
        checkCell(row, col);
        mField[row][col].setState(Cell.CROSS);
    }

    public void addNought(int row, int col) {
        checkCell(row, col);
        mField[row][col].setState(Cell.NOUGHT);
    }

    public void clear(int row, int col) {
        checkCell(row, col);
        mField[row][col].setState(Cell.EMPTY);
    }

    private void checkCell(int row, int col) {
        if (row >= size || row < 0 || col >= size || col < 0) {
            throw new IllegalArgumentException("it's not such cell on the mField");
        }
    }

    private void checkCell(Cell cell) {
        checkCell(cell.getRow(), cell.getCol());
    }

    static private final Cell[] DIRECTIONS = new Cell[]{
            new Cell(0, 1), new Cell(1, 0), new Cell(1, 1)
    };

    private ArrayList<Cell> longestSequence(int state) {
        ArrayList<Cell> result = new ArrayList<Cell>();

        for (int row = 0; row < size; row++) {

            for (int col = 0; col < size; col++) {

                for (Cell dir : DIRECTIONS) {

                    Cell currentCell = mField[row][col];
                    ArrayList<Cell> currentSequence = new ArrayList<Cell>();

                    while (currentCell.getState() == state) {
                        currentSequence.add(currentCell);
                        Cell nextCell = currentCell.plus(dir);

                        try {
                            checkCell(nextCell);
                        } catch (Exception e) {
                            break;
                        }

                        currentCell = mField[nextCell.getRow()][nextCell.getCol()];
                    }

                    if (currentSequence.size() > result.size())
                        result = currentSequence;
                }
            }
        }

        return result;
    }

    public ArrayList<Cell> longestCrossSequence() {
        return longestSequence(Cell.CROSS);
    }

    public ArrayList<Cell> longestNoughtSequence() {
        return longestSequence(Cell.NOUGHT);
    }

    public int longestCrossSequenceSize() {
        return longestCrossSequence().size();
    }

    public int longestNoughtSequenceSize() {
        return longestNoughtSequence().size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                switch (mField[row][col].getState()) {
                    case Cell.EMPTY:
                        stringBuilder.append(' ');
                        break;
                    case Cell.NOUGHT:
                        stringBuilder.append('0');
                        break;
                    case Cell.CROSS:
                        stringBuilder.append('X');
                        break;
                }
                if (col != size - 1) stringBuilder.append('|');
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + Arrays.deepHashCode(mField);
        return result;
    }
}
