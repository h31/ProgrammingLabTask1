public class Field {
    private final int: width;
    private final int: height;

    private final int size;
    private CrossesOrNoughts[][] field;


    public Field(int size) {
        this.size = size;
        field = new CrossesOrNulls[size][size];

        for (int width = 0; width < size; width++) {
            for (int height = 0; height < size; height++) {
                field[width][height] = NOTHING;
            }
        }
    }

    public void putValue(int width, int height, CrossesOrNulls cell){
        field[width][height] = cell;
    }

    public addCross(int width, int height){
        putValue(width, height, CROSS)
    }

    public devastate(int width, int height){
        putValue(width, height, NOTHING)
    }

    public addNull(int width, int height)
    {
        putValue(width, height, NOUGHT)
    }

    public searchLongestSequenceHorizontally{
        private int: max;
        private int: sumCrosses;
        private int: sumNoughts;
        max = 0;
        sumCrosses = 0;
        sumNoughts = 0;
        for (int width = 0; width < size; width++) {
            for (int height = 0; height < size; height++) {
                if (field[width][height] == CROSS {
                    sumNoughts = 0;
                    sumCrosses += 1;
                    if (sumCrosses > max) max = sumCross;
                }
                if (field[width][height] == NOUGHT {
                    sumCrosses = 0;
                    sumNoughts +=1;
                    if (sumNoughts > max) max = sumNoughts;
                }
            }
        }
    }

        public searchLongestSequenceVertically{
            private int: max;
            private int: sumCrosses;
            private int: sumNoughts;
            max = 0;
            sumCrosses = 0;
            sumNoughts = 0;
            for (int height = 0; height < size; height++) {
                for (int width = 0; width < size; width++) {
                    if (field[width][height] == CROSS {
                        sumNoughts = 0;
                        sumCrosses += 1;
                        if (sumCrosses > max) max = sumCross;
                    }
                    if (field[width][height] == NOUGHT {
                        sumCrosses = 0;
                        sumNoughts +=1;
                        if (sumNoughts > max) max = sumNoughts;
                    }
                }
            }
        }
}