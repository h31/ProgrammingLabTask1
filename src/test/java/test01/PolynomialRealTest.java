package test01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import task01.Polynomial;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolynomialRealTest {
    private int ar[] = new int[]{2, 3, 2, 4};
    private int ar1[] = new int[]{-1, 5, 2, 0};
    private int ar2[] = new int[]{0, -3, 1};

    private int sum1[] = new int[]{1, 8, 4, 4};
    private int sum2[] = new int[]{2, 0, 3, 4};
    private int sum3[] = new int[]{-1, 2, 3};

    @Tag("+")
    @Test

    public void sum() {
        assertEquals(new Polynomial(sum1), new Polynomial(ar).sum(new Polynomial(ar1)));
        assertEquals(new Polynomial(sum2), new Polynomial(ar).sum(new Polynomial(ar2)));
        assertEquals(new Polynomial(sum3), new Polynomial(ar1).sum(new Polynomial(ar2)));
        assertEquals(new Polynomial(ar), new Polynomial(sub1).sum(new Polynomial(ar1)));
        assertEquals(new Polynomial(ar), new Polynomial(sub2).sum(new Polynomial(ar2)));
    }

    private int sub1[] = new int[]{3, -2, 0, 4};
    private int sub2[] = new int[]{2, 6, 1, 4};
    private int sub3[] = new int[]{-1, 8, 1};

    @Tag("-")
    @Test
    public void sub() {
        assertEquals(new Polynomial(sub1), new Polynomial(ar).sub(new Polynomial(ar1)));
        assertEquals(new Polynomial(sub2), new Polynomial(ar).sub(new Polynomial(ar2)));
        assertEquals(new Polynomial(sub3), new Polynomial(ar1).sub(new Polynomial(ar2)));
    }

    private int mul1[] = new int[]{-2, 7, 17, 12, 24, 8};
    private int mul2[] = new int[]{0, -6, -7, -3, -10, 4};
    private int mul3[] = new int[]{0, 3, -16, -1, 2};

    @Tag("*")
    @Test
    public void mult() {
        assertEquals(new Polynomial(mul1), new Polynomial(ar).mult(new Polynomial(ar1)));
        assertEquals(new Polynomial(mul2), new Polynomial(ar).mult(new Polynomial(ar2)));
        assertEquals(new Polynomial(mul3), new Polynomial(ar1).mult(new Polynomial(ar2)));
    }

    int div1[] = new int[]{-4, 2};
    int div2[] = new int[]{14, 4};
    int div3[] = new int[]{2};

    @Tag("/")
    @Test
    public void div() {
        assertEquals(new Polynomial(div1), new Polynomial(ar).div(new Polynomial(ar1)));
        assertEquals(new Polynomial(div2), new Polynomial(ar).div(new Polynomial(ar2)));
        assertEquals(new Polynomial(div3), new Polynomial(ar1).div(new Polynomial(ar2)));
    }

    private int rem1[] = new int[]{-2, 25};
    private int rem2[] = new int[]{2, 45};
    private int rem3[] = new int[]{-1, 11};

    @Tag("%")
    @Test
    public void remainder() {
        assertEquals(new Polynomial(rem1), new Polynomial(ar).remainder(new Polynomial(ar1)));
        assertEquals(new Polynomial(rem2), new Polynomial(ar).remainder(new Polynomial(ar2)));
        assertEquals(new Polynomial(rem3), new Polynomial(ar1).remainder(new Polynomial(ar2)));
    }

    @Test
    public void check() {
    Polynomial e1 = new Polynomial(ar1).mult(new Polynomial(div1));
    Polynomial e2 = new Polynomial(ar2).mult(new Polynomial(div2));
    Polynomial res1 = new Polynomial(e1).sum(new Polynomial(rem1));
    Polynomial res2 = new Polynomial(e2).sum(new Polynomial(rem2));

    assertEquals(new Polynomial(ar), res1);
    assertEquals(new Polynomial(ar), res2);
    }

}
