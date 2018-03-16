package task01;
import java.util.Arrays;

public class Polyn {
    private int array[];
    private int degree;

    public int getDegree() {
        return array.length - 1;
    }

    public Polyn(int[] array) {
        this.array = new int[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
        this.degree = getDegree();
    }

    private Polyn(int degree) {
        this.degree = degree;
        this.array = new int[this.degree + 1];
    }

    public Polyn(Polyn p) {
        this.degree = p.degree;
        this.array = new int[this.degree + 1];
        System.arraycopy(p.array, 0, this.array, 0, p.degree + 1);
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("");
        boolean isZero = true;
        for (int i = this.degree; i >= 0; i--) {
            if (this.array[i] == 0) continue;
            if (i == 0) {
                if (this.array[i] < 0) s.append(this.array[i]);
                else if (!isZero) s.append("+" + this.array[i]);
                else s.append(this.array[i]);
                break;
            }
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
        if (!(other instanceof Polyn)) return false;
        Polyn p = (Polyn) other;
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

    public Polyn sum(Polyn p2) {
        int max = Math.max(this.degree, p2.degree);
        int min = Math.min(this.degree, p2.degree);
        Polyn res = new Polyn(max);
        for (int i = 0; i <= min; i++) {
            res.array[i] = this.array[i] + p2.array[i];
        }
        if (max == this.degree) System.arraycopy(this.array, min + 1,
                res.array, min + 1, max - min);
        else if (max == p2.degree) System.arraycopy(p2.array, min + 1,
                res.array, min + 1, max - min);
        res.deleteZero();
        return res;
    }

    public Polyn inverted() {
        Polyn res = new Polyn(this);
        for (int i = 0; i <= res.degree; i++) {
            res.array[i] = -res.array[i];
        }
        return res;
    }

    public Polyn sub(Polyn p2) {
        Polyn newp2 = p2.inverted();
        Polyn res = this.sum(newp2);
        return res;
    }

    public Polyn mul(Polyn p2) {
        Polyn res = new Polyn(this.degree + p2.degree);
        for (int i = this.degree; i >= 0; i--) {
            for (int j = p2.degree; j >= 0; j--) {
                res.array[i + j] += this.array[i] * p2.array[j];
            }
        }
        res.deleteZero();
        return res;
    }

    public Polyn div(Polyn p2) {
       if (this.equals(p2)) {
            Polyn res = new Polyn(1);
            res.array[0] = 1;
            return res;
        }
        this.deleteZero();
        p2.deleteZero();
        Polyn dividend = new Polyn(this);
        Polyn res = new Polyn(this.degree);
        Polyn res1 = new Polyn(this.degree);
        Polyn divisorChange;
        int coef;
        while (dividend.degree >= p2.degree) {
            coef = dividend.array[dividend.degree] / p2.array[p2.degree];
            res.array[dividend.degree - p2.degree] = coef;
            Arrays.fill(res1.array, 0);
            res1.array[dividend.degree - p2.degree] = coef;
            divisorChange = p2.mul(res1);
            dividend = dividend.sub(divisorChange);
        }
        res.deleteZero();
        return res;
    }

    public Polyn remainder(Polyn p2) {
        if (this.equals(p2)) {
            Polyn res = new Polyn(1);
            res.array[0] = 1;
            return res;
        }
        this.deleteZero();
        p2.deleteZero();
        Polyn dividend = new Polyn(this);
        Polyn res = new Polyn(this.degree);
        Polyn res1 = new Polyn(this.degree);
        Polyn divisorChange;
        int coef;
        while (dividend.degree >= p2.degree) {
            coef = dividend.array[dividend.degree] / p2.array[p2.degree];
            res.array[dividend.degree - p2.degree] = coef;
            Arrays.fill(res1.array, 0);
            res1.array[dividend.degree - p2.degree] = coef;
            divisorChange = p2.mul(res1);
            dividend = dividend.sub(divisorChange);
        }
        dividend.deleteZero();
        return dividend;
    }

    private void deleteZero() {
        int i;
        if (this.degree == 0) return;
        for (i = this.degree; i >= 0; i--) {
            if (this.array[i] != 0) break;
        }
        if (i == this.degree) return;
        int newar[] = new int[this.degree + 1];
        System.arraycopy(this.array, 0, newar, 0, this.degree + 1);
        this.degree = i;
        this.array = new int[this.degree + 1];
        System.arraycopy(newar, 0, this.array, 0, this.degree + 1);
    }
}
