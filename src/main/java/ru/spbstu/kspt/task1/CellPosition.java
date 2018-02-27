package ru.spbstu.kspt.task1;

public class CellPosition {
    private final int row;
    private final int col;

    public CellPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public CellPosition shift(CellPosition other) {
        return new CellPosition(row + other.row, col + other.col);
    }

    public Cell getCell(Cell[][] field) {
        return field[row][col];
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        return "[" + row + "," + col + "]";
    }
}
