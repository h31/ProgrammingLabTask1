package ru.spbstu.kspt.task1;

import java.util.ArrayList;
import java.util.Arrays;

import static ru.spbstu.kspt.task1.Cell.State.*;

public class TicTacToeField {
    private final int size;
    private Cell[][] mField;

    public TicTacToeField(int size) {
        if (size <= 0) throw new IllegalArgumentException("size can't be <= 0");

        this.size = size;
        mField = new Cell[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                mField[row][col] = new Cell();
            }
        }
    }

    private void changeState(int row, int col, Cell.State state) {
        if (!cellOnField(row, col)) throw new IllegalArgumentException("it's not such cell on the mField");
        mField[row][col].setState(state);
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

    private final CellPosition[] DIRECTIONS = new CellPosition[]{
            new CellPosition(-1, 1), new CellPosition(0, 1), new CellPosition(1, 0), new CellPosition(1, 1)
    };

    private ArrayList<CellPosition> longestSequence(Cell.State state) {
        ArrayList<CellPosition> result = new ArrayList<>();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                for (CellPosition dir : DIRECTIONS) {
                    CellPosition currentCellPosition = new CellPosition(row, col);
                    ArrayList<CellPosition> currentSequence = new ArrayList<CellPosition>();

                    while (currentCellPosition.getCell(mField).getState() == state) {
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

    public ArrayList<CellPosition> longestCrossSequence() {
        ArrayList<CellPosition> longestSequence = longestSequence(CROSS);
        ArrayList<CellPosition> result = new ArrayList<CellPosition>();

        if (!longestSequence.isEmpty()) {
            result.add(longestSequence.get(0));
            result.add(longestSequence.get(longestSequence.size() - 1));
        }

        return result;
    }

    public ArrayList<CellPosition> longestNoughtSequence() {
        ArrayList<CellPosition> longestSequence = longestSequence(NOUGHT);
        ArrayList<CellPosition> result = new ArrayList<CellPosition>();

        if (!longestSequence.isEmpty()) {
            result.add(longestSequence.get(0));
            result.add(longestSequence.get(longestSequence.size() - 1));
        }

        return result;
    }

    public int longestCrossSequenceSize() {
        return longestSequence(CROSS).size();
    }

    public int longestNoughtSequenceSize() {
        return longestSequence(NOUGHT).size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                switch (mField[row][col].getState()) {
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
                if (this.mField[row][col] != this.mField[row][col]) return false;
            }
        }

        return true;
    }
}
