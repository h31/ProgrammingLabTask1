package ru.spbstu.kspt.task1;

public class Cell {
    private int width;

    private int height;

    public void CrossesOrNoughts(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "|" + width + "," + height + "|";
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        Cell cell = (Cell) object;

        if (width != cell.width) return false;
        if (height != cell.height) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + width;
        result = 31 * result + height;
        return result;
    }
}