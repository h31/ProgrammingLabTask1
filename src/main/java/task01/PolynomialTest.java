package task01;

public class PolynomialTest {
    public static void main(String[] args) {
        int ar[] = new int[]{2, 1, 6, 0};
        Polynomial p = new Polynomial(ar);
        System.out.print("p: ");
        p.print();
        int ar1[] = new int[]{0,-1};
        Polynomial p1 = new Polynomial(ar1);
        System.out.print("p1: ");
        p1.print();
        Polynomial res = p.sum(p1);
        System.out.print("p + p1 = ");
        res.print();
        Polynomial res1 = p.sub(p1);
        System.out.print("p - p1 = ");
        res1.print();
        Polynomial res2 = p.mult(p1);
        System.out.print("p * p1 = ");
        res2.print();
        Polynomial res3 = p.div(p1);
        System.out.print("p / p1 = ");
        res3.print();
        Polynomial res4 = p.remainder(p1);
        System.out.print("p % p1 = ");
        res4.print();
    }
}
