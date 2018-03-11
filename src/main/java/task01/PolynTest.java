package task01;

public class PolynTest {
    public static void main(String[] args) {
        double ar[] = new double[]{2, 1, 6, 0};
        Polyn p = new Polyn(ar);
        System.out.print("p: ");
        p.print();
        double ar1[] = new double[]{0, -2, 4};
        Polyn p1 = new Polyn(ar1);
        System.out.print("p1: ");
        p1.print();
        Polyn res = p.sum(p1);
        System.out.print("p + p1 = ");
        res.print();
        Polyn res1 = p.sub(p1);
        System.out.print("p - p1 = ");
        res1.print();
        Polyn res2 = p.mul(p1);
        System.out.print("p * p1 = ");
        res2.print();
        Polyn res3 = p.div(p1);
        System.out.print("p / p1 = ");
        res3.print();
        Polyn res4 = p.remainder(p1);
        System.out.print("p % p1 = ");
        res4.print();
    }
}
