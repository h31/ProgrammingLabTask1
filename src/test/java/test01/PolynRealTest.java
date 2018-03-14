package test01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import task01.Polyn;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolynRealTest {
    private int ar[] = new int[]{2, 3, 2, 4};
    private int ar1[] = new int[]{-1, 5, 2, 0};
    private int ar2[] = new int[]{0, -3, 1};

    @Tag("+")
    @Test
    public void sum() {
        int sum1[] = new int[]{1, 8, 4, 4};
        int sum2[] = new int[]{2, 0, 3, 4};
        int sum3[] = new int[]{-1, 2, 3};

        assertEquals(new Polyn(sum1), new Polyn(ar).sum(new Polyn(ar1)));
        assertEquals(new Polyn(sum2), new Polyn(ar).sum(new Polyn(ar2)));
        assertEquals(new Polyn(sum3), new Polyn(ar1).sum(new Polyn(ar2)));
    }

    @Tag("-")
    @Test
    public void sub() {
        int sub1[] = new int[]{3, -2, 0, 4};
        int sub2[] = new int[]{2, 6, 1, 4};
        int sub3[] = new int[]{-1, 8, 1};

        assertEquals(new Polyn(sub1), new Polyn(ar).sub(new Polyn(ar1)));
        assertEquals(new Polyn(sub2), new Polyn(ar).sub(new Polyn(ar2)));
        assertEquals(new Polyn(sub3), new Polyn(ar1).sub(new Polyn(ar2)));
    }

    @Tag("*")
    @Test
    public void mul() {
        int mul1[] = new int[]{-2, 7, 17, 12, 24, 8};
        int mul2[] = new int[]{0, -6, -7, -3, -10, 4};
        int mul3[] = new int[]{0, 3, -16, -1, 2};

        assertEquals(new Polyn(mul1), new Polyn(ar).mul(new Polyn(ar1)));
        assertEquals(new Polyn(mul2), new Polyn(ar).mul(new Polyn(ar2)));
        assertEquals(new Polyn(mul3), new Polyn(ar1).mul(new Polyn(ar2)));
    }

    @Tag("/")
    @Test
    public void div() {
        int div1[] = new int[]{-4, 2};
        int div2[] = new int[]{14, 4};
        int div3[] = new int[]{2};

        assertEquals(new Polyn(div1), new Polyn(ar).div(new Polyn(ar1)));
        assertEquals(new Polyn(div2), new Polyn(ar).div(new Polyn(ar2)));
        assertEquals(new Polyn(div3), new Polyn(ar1).div(new Polyn(ar2)));
    }

    @Tag("%")
    @Test
    public void remainder() {
        int rem1[] = new int[]{-2, 25};
        int rem2[] = new int[]{2, 45};
        int rem3[] = new int[]{-1, 11};

        assertEquals(new Polyn(rem1), new Polyn(ar).remainder(new Polyn(ar1)));
        assertEquals(new Polyn(rem2), new Polyn(ar).remainder(new Polyn(ar2)));
        assertEquals(new Polyn(rem3), new Polyn(ar1).remainder(new Polyn(ar2)));
    }

}
