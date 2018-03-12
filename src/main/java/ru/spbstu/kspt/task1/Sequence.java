package ru.spbstu.kspt.task1;

import java.util.Objects;

import static java.lang.Math.abs;

public class Sequence {
    private CellPosition startPosition;
    private CellPosition endPosition;

    public Sequence() {
    }

    public Sequence(CellPosition startPosition, CellPosition endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public static final CellPosition[] DIRECTIONS = new CellPosition[]{
            new CellPosition(-1, 1), new CellPosition(0, 1),
            new CellPosition(1, 0), new CellPosition(1, 1)
    };

    public void add(CellPosition newCellPosition) {
        if (startPosition == null) this.startPosition = newCellPosition;
        this.endPosition = newCellPosition;
    }

    /**
     * @return {@code null} - if direction not from DIRECTIONS.
     */
    public CellPosition getDirection() {
        int deltaRow = endPosition.getRow() - startPosition.getRow();
        int deltaCol = endPosition.getCol() - startPosition.getCol();

        int directionRow, directionCol;

        if (deltaRow == 0) directionRow = 0;
        else directionRow = deltaRow / abs(deltaRow);
        if (deltaCol == 0) directionCol = 0;
        else directionCol = deltaCol / abs(deltaCol);

        CellPosition direction = new CellPosition(directionRow, directionCol);
        for (CellPosition dir : DIRECTIONS) {
            if (dir.equals(direction)) return direction;
        }

        return null;
    }

    public int size() {
        if (startPosition == null) return 0;
        if (startPosition.getCol() == endPosition.getCol())
            return abs(startPosition.getRow() - endPosition.getRow()) + 1;
        return abs(startPosition.getCol() - endPosition.getCol()) + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sequence sequence = (Sequence) o;
        return startPosition.equals(sequence.startPosition) &&
                endPosition.equals(sequence.endPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startPosition, endPosition);
    }

    @Override
    public String toString() {
        return startPosition.toString() + endPosition.toString();
    }
}
