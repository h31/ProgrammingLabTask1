package task01;
import java.util.Arrays;
import java.util.List;

public class Polynomial {
    private int array[];
    private int degree;

    public int getDegree() {
        return array.length - 1;
    }

    public Polynomial(int[] array) {
        this.array = new int[array.length];
        this.array = array.clone();
        this.degree = getDegree();
    }

    private Polynomial(int degree) {
        this.degree = degree;
        this.array = new int[this.degree + 1];
    }

    public Polynomial(Polynomial p) {
        this.degree = p.degree;
        this.array = new int[this.degree + 1];
        this.array = p.array.clone();
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        boolean isZero = true;
        for (int i = this.degree; i >= 0; i--) {
            if (i == 0) {
                if (this.array[i] > 0 && !isZero) s.append("+");
                if (this.array[i] != 0) s.append(this.array[i]);
                break;
            }
            if (this.array[i] == 0) continue;
            if (this.array[i] < 0) {
                if (this.array[i] == -1) {
                    s.append("-");
                } else s.append(this.array[i]);
            }
            if (this.array[i] > 0) {
                if (!isZero) s.append("+");
                if (this.array[i] != 1) s.append(this.array[i]);
            }
            if (this.array[i] != 0) isZero = false;
            if (i == 1) s.append("x");
            else s.append("x^" + i);
        }
        return s.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        if (!(other instanceof Polynomial)) return false;
        Polynomial p = (Polynomial) other;
        return Arrays.equals(array, p.array);
    }

    @Override
    public int hashCode() {
        int result = degree;
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    public void print() {
        System.out.println(this);
    }

    public Polynomial sum(Polynomial p2) {
        int max = Math.max(this.degree, p2.degree);
        int min = Math.min(this.degree, p2.degree);
        Polynomial res = new Polynomial(max);
        for (int i = 0; i <= max; i++) {
            if (i <= min) res.array[i] = this.array[i] + p2.array[i];
            else {
                if (max == this.degree) res.array[i] = this.array[i];
                else res.array[i] = p2.array[i];
            }
        }
        res.deleteZeros();
        return res;
    }

    public Polynomial inverted() {
        Polynomial res = new Polynomial(this);
        for (int i = 0; i <= res.degree; i++) {
            res.array[i] = -res.array[i];
        }
        return res;
    }

    public Polynomial sub(Polynomial p2) {
        Polynomial newp2 = p2.inverted();
        Polynomial res = this.sum(newp2);
        return res;
    }

    public Polynomial mult(Polynomial p2) {
        Polynomial res = new Polynomial(this.degree + p2.degree);
        for (int i = this.degree; i >= 0; i--) {
            for (int j = p2.degree; j >= 0; j--) {
                res.array[i + j] += this.array[i] * p2.array[j];
            }
        }
        res.deleteZeros();
        return res;
    }
    public Polynomial div(Polynomial p2) {
        return divideWithRemainder(p2).get(0);
    }

    public Polynomial remainder(Polynomial p2) {
        return divideWithRemainder(p2).get(1);
    }

    private List<Polynomial> divideWithRemainder(Polynomial p2) {
        if (this.equals(p2)) {
            Polynomial quotient = new Polynomial(1);
            Polynomial remainder = new Polynomial(1);
            quotient.array[0] = 1;
            remainder.array[0] = 0;
            return Arrays.asList(quotient, remainder);
        }
        this.deleteZeros();
        p2.deleteZeros();
        if (p2.array[p2.degree] == 0) throw new IllegalArgumentException();
        Polynomial dividend = new Polynomial(this);
        Polynomial quotient = new Polynomial(this.degree);
        Polynomial multiply;
        int coeff;
        while (dividend.degree >= p2.degree) {
            coeff = dividend.array[dividend.degree] / p2.array[p2.degree];
            quotient.array[dividend.degree - p2.degree] = coeff;
            Polynomial res = new Polynomial(this.degree);
            Arrays.fill(res.array, 0);
            res.array[dividend.degree - p2.degree] = coeff;
            multiply = p2.mult(res);
            dividend = dividend.sub(multiply);
        }
        quotient.deleteZeros();
        dividend.deleteZeros();
        return Arrays.asList(quotient, dividend);
    }

    private void deleteZeros() {
        int i;
        if (this.degree == 0) return;
        for (i = this.degree; i >= 0; i--) {
            if (this.array[i] != 0) break;
        }
        if (i == this.degree) return;
        int newar[] = Arrays.copyOfRange(this.array, 0, this.degree+1);
        this.degree = i;
        this.array = new int[this.degree + 1];
        this.array = Arrays.copyOfRange(newar, 0, this.degree+1);
    }
}
