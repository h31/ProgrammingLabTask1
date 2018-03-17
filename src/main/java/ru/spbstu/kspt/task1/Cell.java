public class Cell {
    private final int x;

    private final int y;

    public CrossesOrNoughts(int x, int y) {
        this.x = x;
        this.y = y;
    }

    if (x < 0 || y < 0) {
        throw new IllegalArgumentException()
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

        if (x != cell.x) return false;
        if (y != cell.y) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }
}