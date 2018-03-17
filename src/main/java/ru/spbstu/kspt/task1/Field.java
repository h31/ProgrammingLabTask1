public class Field {
    private final int: width;
    private final int: height;

    private final int size;
    private CrossesOrNoughts[][] field;


    public Field(int size) {
        this.size = size;
        if (size <= 0){
            throw new IllegalArgumentException()
        }
        field = new CrossesOrNoughts[size][size];

        for (int width = 0; width < size; width++) {
            for (int height = 0; height < size; height++) {
                field[width][height] = NOTHING;
            }
        }
    }

    public void putValue(int width, int height, CrossesOrNoughts cell){
        field[width][height] = cell;
    }

    public addCross(int width, int height){
        putValue(width, height, CROSS)
    }

    public devastate(int width, int height){
        putValue(width, height, NOTHING)
    }

    public addNought(int width, int height)
    {
        putValue(width, height, NOUGHT)
    }

    public searchLongestSequenceHorizontally(int xoro){
        private int: max;
        private int: sumNeedful;
        private CrossesOrNoughts: cell;
        if xoro = 0 {
            cell = NOUGHT
        }
        else {
            cell = CROSS
        }
        max = 0;
        sumNeedful = 0;
        for (int height = 0; height < size; height++) {
            for (int width = 0; width < size; width++) {
                if (field[width][height] == cell) {
                    sumNeedful += 1;
                    if (sumNeedful > max) {
                        max = sumNeedful;
                    }
                }
                else {
                    sumNeedful = 0;
                }
            }
        }
        return max;
    }

    public searchLongestSequenceVertically(CrossesOrNoughts cell){
        private int: max;
        private int: sumNeedful;
        private CrossesOrNoughts: cell;
        if xoro = 0 {
            cell = NOUGHT
        }
        else {
            cell = CROSS
        }
        max = 0;
        sumNeedful = 0;
        for (int width = 0; width < size; width++) {
            for (int height = 0; height < size; height++) {
                if (field[width][height] == cell) {
                    sumNeedful += 1;
                    if (sumNeedful > max) {
                        max = sumNeedful;
                    }
                }
                else {
                    sumNeedful = 0;
                }
            }
        }
        return max;
    }

    public searchLongestSequenceDiagonally(int xoro){
        private int: max;
        private int: i;
        private int: sumNeedful;
        private CrossesOrNoughts: cell;
        if xoro = 0 {
            cell = NOUGHT
        }
        else {
            cell = CROSS
        }
        max = 0;
        sumNeedful = 0;
        for (int height = 0; height < size; height++) {
            for (int width = 0; width < size; width++) {
                i = 0;
                if (field[width][height] == cell) {
                    sumNeedful += 1;
                    max = sumNeedful;
                    while (i + width + 1 < size) {
                        i++;
                        if (field[width][height] == field[width + i][height + i]){
                            sumNeedful += 1;
                            if (sumNeedful > max) {
                                max = sumNeedful
                            }
                        }
                        else {
                            sumNeedful = 0;
                        }
                    }
                }
            }
        }

        i = 0;
        sumNeedful = 0;

        for (int height = 0; height < size; height++) {
            for (int width = size - 1; width == 0; width--) {
                i = 0;
                if (field[width][height] == cell) {
                    sumNeedful += 1;
                    max = sumNeedful;
                    while (i + height + 1 < size) {
                        i++;
                        if (field[width][height] == field[width - i][height + i]){
                            sumNeedful += 1;
                            if (sumNeedful > max) {
                                max = sumNeedful
                            }
                        }
                        else {
                            sumNeedful = 0;
                        }
                    }
                }
            }
        }
        return max;
    }

    @Override
    public String toString() {
        StringBuilder stringField = new StringBuilder();
        for (int height = 0; height < size; height++) {
            for (int width = 0; width < size; width++) {
                switch (field[width][height]) {
                    case CROSS:
                        stringField.append('x');
                        break;
                    case NOTHING:
                        stringField.append(' ');
                        break;
                    case NOUGHT:
                        stringField.append('o');
                        break;
                }
            }
        }
        return stringField.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        Field field1 = (Field) object;

        if (size != field1.size) return false;
        if (!java.util.Arrays.deepEquals(field, field1.field)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + size;
        result = 31 * result + Arrays.deepHashCode(field);
        return result;
    }
}