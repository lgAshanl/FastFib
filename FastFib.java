import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by gas on 29.02.16.
 */

public class FastFib {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        BigInteger a = BigInteger.ONE, ta,
                   b = BigInteger.ONE, tb,
                   c = BigInteger.ONE, rc = BigInteger.ZERO,  tc,
                   d = BigInteger.ZERO, rd = BigInteger.ONE;

        while (n != 0)
        {
            if (n % 2 != 0)    // Если степень нечетная
            {
                // Умножаем вектор R на матрицу A
                tc = rc;
                rc = rc.multiply(a).add(rd.multiply(c));
                rd = tc.multiply(b).add(rd.multiply(d));
            }

            // Умножаем матрицу A на саму себя
            ta = a; tb = b; tc = c;
            a = a.multiply(a).add(b.multiply(c));
            b = ta.multiply(b).add(b.multiply(d));
            c = c.multiply(ta).add(d.multiply(c));
            d = tc.multiply(tb).add(d.multiply(d));

            n >>= 1;  // Уменьшаем степень вдвое

        }
        System.out.println(rc);
    }
}
