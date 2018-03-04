package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {


    @Test
    void compare() {
        assertEquals(-1,
                BigBigInt.compare(new BigBigInt("461849213528055328502"),
                        new BigBigInt("461849213628055328502")));
        assertEquals(-1,
                BigBigInt.compare(new BigBigInt("  udsihfs  3798196214 uaoudj21 "),
                        new BigBigInt(" 0000 3423248jajklf =12321321")));

        assertEquals(0,
                BigBigInt.compare(new BigBigInt("9172470126471204862176"),
                        new BigBigInt("9172470126471204862176")));
        assertEquals(0,
                BigBigInt.compare(new BigBigInt("   fusaljfa4378748320023432yo7hfa "),
                        new BigBigInt("   fusaljfa4378748320023432yo7hfa ")));

        assertEquals(1,
                BigBigInt.compare(new BigBigInt("763068415235893205639275"),
                        new BigBigInt("763068415235893105639275")));
        assertEquals(1,
                BigBigInt.compare(new BigBigInt("    743276yuafhsbnamm;of73269432"),
                        new BigBigInt("8032-79126147")));
    }

    @Test
    void add() {
        assertEquals(new BigBigInt("28530940900897641653").getValue(),
                BigBigInt.add(new BigBigInt("2853094012060ufjkaj7840812ijfga"),
                        new BigBigInt("  7802u89jiufsa800841")).getValue());
    }

    @Test
    void subtract() {
        assertEquals(new BigBigInt("28530939340318039971").getValue(),
                BigBigInt.subtract(new BigBigInt("2853094012060ufjkaj7840812ijfga"),
                        new BigBigInt("  7802u89jiufsa800841")).getValue());
    }

    @Test
    void multiply() {
        assertEquals(new BigBigInt("22262401584515588627058511722892").getValue(),
                BigBigInt.multiply(new BigBigInt("2853094012060ufjkaj7840812ijfga"),
                        new BigBigInt("  7802u89jiufsa800841")).getValue());
    }


    @Test
    void divide() {
        assertEquals(new BigBigInt("39652").getValue(),
                BigBigInt.divide(new BigBigInt("3094012060ufjkaj7840812ijfga"),
                        new BigBigInt("  7802u89jiufsa800841")).getValue());
    }


    @Test
    void remain() {
        assertEquals(new BigBigInt("406444945376").getValue(),
                BigBigInt.remain(new BigBigInt("3094012060ufjkaj78412ijfga"),
                        new BigBigInt("  7802u89jiufsa800841")).getValue());
    }
}
