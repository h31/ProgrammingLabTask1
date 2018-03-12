package ru.spbstu.kspt.task1;

import java.util.Arrays;

import static ru.spbstu.kspt.task1.Cell.*;
import static ru.spbstu.kspt.task1.Sequence.DIRECTIONS;


public class TicTacToeField {
    private final int size;
    private Cell[][] mField;

    public TicTacToeField(int size) {
        if (size <= 0) throw new IllegalArgumentException("size can't be <= 0");

        this.size = size;
        mField = new Cell[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                mField[row][col] = EMPTY;
            }
        }
    }

    private void changeState(int row, int col, Cell cell) {
        if (!cellOnField(row, col)) throw new IllegalArgumentException("it's not such cell on the mField");
        mField[row][col] = cell;
    }

    public void addCross(int row, int col) {
        changeState(row, col, CROSS);
    }

    public void addNought(int row, int col) {
        changeState(row, col, NOUGHT);
    }

    public void clear(int row, int col) {
        changeState(row, col, EMPTY);
    }

    private boolean cellOnField(int row, int col) {
        return row < size && row >= 0 && col < size && col >= 0;
    }

    private boolean cellOnField(CellPosition cellPosition) {
        return cellOnField(cellPosition.getRow(), cellPosition.getCol());
    }

    private Sequence longestSequence(Cell cell) {
        Sequence result = new Sequence();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                for (CellPosition dir : DIRECTIONS) {
                    CellPosition currentCellPosition = new CellPosition(row, col);
                    Sequence currentSequence = new Sequence();

                    while (currentCellPosition.getCell(mField) == cell) {
                        currentSequence.add(currentCellPosition);
                        CellPosition nextCellPosition = currentCellPosition.shift(dir);

                        if (!cellOnField(nextCellPosition)) break;

                        currentCellPosition = nextCellPosition;
                    }

                    if (currentSequence.size() > result.size())
                        result = currentSequence;
                }
            }
        }

        return result;
    }

    public Sequence longestCrossSequence() {
        return longestSequence(CROSS);
    }

    public Sequence longestNoughtSequence() {
        return longestSequence(NOUGHT);
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
                switch (mField[row][col]) {
                    case EMPTY:
                        stringBuilder.append(' ');
                        break;
                    case NOUGHT:
                        stringBuilder.append('0');
                        break;
                    case CROSS:
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TicTacToeField)) return false;

        TicTacToeField other = (TicTacToeField) obj;

        if (!(other.size == this.size)) return false;

        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                if (!this.mField[row][col].equals(other.mField[row][col])) return false;
            }
        }

        return true;
    }
}
