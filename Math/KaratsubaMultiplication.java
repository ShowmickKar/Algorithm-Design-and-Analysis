/*
 * The Karatsuba algorithm is a FAST MULTIPLICATION algorithm that beats our traditional approach to multiplication which we learned in our second or third grade.
 * As opposed to the traditional method which has a computational run time of O(n^2) the Karatsuba algorithm does much better taking only O(n^lg3) or O(n^1.58).
 * This is a major improvement over the second-grade method. The improvement can be noticed when the input size gets extremely large.
*/

public class KaratsubaMultiplication {
    public static void main(String[] args) {
        System.out.println(karatsuba(1234, 5678));
    }

    public static long karatsuba(long x, long y) {
        if (x < 10 | y < 10) {
            return x * y;
        }

        long n = (long) (Math.max(Math.log10(x), Math.log10(y)) + 1);
        long m = n / 2;
        long a = (long) (x / Math.pow(10, m));
        long b = (long) (x % Math.pow(10, m));
        long c = (long) (y / Math.pow(10, m));
        long d = (long) (y % Math.pow(10, m));

        long ac = karatsuba(a, c);
        long bd = karatsuba(b, d);
        long adPlusBc = karatsuba(a + b, c + d) - ac - bd;

        return (long) (ac * Math.pow(10, 2 * m) + adPlusBc * Math.pow(10, m) + bd);
    }
}

// Reference: https:// www.youtube.com/watch?v=yWI2K4jOjFQ&ab_channel=Insidecode
