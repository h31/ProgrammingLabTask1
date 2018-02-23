package ru.spbstu.kspt.task1;

public class Cell {
    public final static int EMPTY = 0;
    public final static int NOUGHT = 1;
    public final static int CROSS = 2;

    private final int row;
    private final int col;
    private int state;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        state = EMPTY;
    }

    public void setState(int state) {
        if (state == EMPTY || state == NOUGHT || state == CROSS) {
            this.state = state;
        } else throw new IllegalArgumentException("illegal state of cell");
    }

    public Cell plus(Cell other) {
        return new Cell(row + other.row, col + other.col);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getState() {
        return state;
    }

    @Override
    public String toString() {
        return "[" + row + "," + col + "]";
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        result = 31 * result + state;
        return result;
    }
}
