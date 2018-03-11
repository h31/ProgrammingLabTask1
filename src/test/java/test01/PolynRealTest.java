package test01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import task01.Polyn;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolynRealTest {
    private double ar[] = new double[]{2, 3, 2, 4};
    private double ar1[] = new double[]{-1, 5, 2, 0};
    private double ar2[] = new double[]{0, -3, 1};

    @Tag("+")
    @Test
    public void sum() {
        double sum1[] = new double[]{1, 8, 4, 4};
        double sum2[] = new double[]{2, 0, 3, 4};
        double sum3[] = new double[]{-1, 2, 3};

        assertEquals(new Polyn(sum1), new Polyn(ar).sum(new Polyn(ar1)));
        assertEquals(new Polyn(sum2), new Polyn(ar).sum(new Polyn(ar2)));
        assertEquals(new Polyn(sum3), new Polyn(ar1).sum(new Polyn(ar2)));
    }

    @Tag("-")
    @Test
    public void sub() {
        double sub1[] = new double[]{3, -2, 0, 4};
        double sub2[] = new double[]{2, 6, 1, 4};
        double sub3[] = new double[]{-1, 8, 1};

        assertEquals(new Polyn(sub1), new Polyn(ar).sub(new Polyn(ar1)));
        assertEquals(new Polyn(sub2), new Polyn(ar).sub(new Polyn(ar2)));
        assertEquals(new Polyn(sub3), new Polyn(ar1).sub(new Polyn(ar2)));
    }

    @Tag("*")
    @Test
    public void mul() {
        double mul1[] = new double[]{-2, 7, 17, 12, 24, 8};
        double mul2[] = new double[]{0, -6, -7, -3, -10, 4};
        double mul3[] = new double[]{0, 3, -16, -1, 2};

        assertEquals(new Polyn(mul1), new Polyn(ar).mul(new Polyn(ar1)));
        assertEquals(new Polyn(mul2), new Polyn(ar).mul(new Polyn(ar2)));
        assertEquals(new Polyn(mul3), new Polyn(ar1).mul(new Polyn(ar2)));
    }

    @Tag("/")
    @Test
    public void div() {
        double div1[] = new double[]{-4, 2};
        double div2[] = new double[]{14, 4};
        double div3[] = new double[]{2};

        assertEquals(new Polyn(div1), new Polyn(ar).div(new Polyn(ar1)));
        assertEquals(new Polyn(div2), new Polyn(ar).div(new Polyn(ar2)));
        assertEquals(new Polyn(div3), new Polyn(ar1).div(new Polyn(ar2)));
    }

    @Tag("%")
    @Test
    public void remainder() {
        double rem1[] = new double[]{-2, 25};
        double rem2[] = new double[]{2, 45};
        double rem3[] = new double[]{-1, 11};

        assertEquals(new Polyn(rem1), new Polyn(ar).remainder(new Polyn(ar1)));
        assertEquals(new Polyn(rem2), new Polyn(ar).remainder(new Polyn(ar2)));
        assertEquals(new Polyn(rem3), new Polyn(ar1).remainder(new Polyn(ar2)));
    }

}
