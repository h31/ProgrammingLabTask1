package ru.spbstu.kspt.task1;

import static ru.spbstu.kspt.task1.Cell.State.*;

public class Cell {

    public enum State {
        EMPTY,
        NOUGHT,
        CROSS;
    }

    private State state;

    public Cell() {
        state = EMPTY;
    }

    public void setState(State state) {
        if (state == EMPTY || state == NOUGHT || state == CROSS) {
            this.state = state;
        } else throw new IllegalArgumentException("illegal state of cell");
    }

    public State getState() {
        return state;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Cell cell = (Cell) other;

        return state == cell.state;
    }

    @Override
    public int hashCode() {
        return state != null ? state.hashCode() : 0;
    }
}
