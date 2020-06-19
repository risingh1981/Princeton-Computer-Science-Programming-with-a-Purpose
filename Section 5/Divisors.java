/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Course: Princeton: Computer Science: Programming with a Purpose
 *
 *  Compilation: javac-introcs Divisors.java
 *  Execution: java-introcs Divisors a b
 *
 *  Purpose: This program takes two integers, a and b, and outputs the greatest
 *  common divisor, least common multiple, whether the two numbers are relatively
 *  prime, and the number of integers between 1 and n that are relatively prime.
 *
 *  % java-introcs Divisors 1440 408
 *  gcd(1440, 408) = 24
 *  lcm(1440, 408) = 24480
 *  areRelativelyPrime(1440, 408) = false
 *  totient(1440) = 384
 *  totient(408) = 128
 *
 **************************************************************************** */

public class Divisors {

    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        int absA = Math.abs(a);
        int absB = Math.abs(b);
        int temp;

        if (absA == 0 && absB == 0) {
            return 0;
        }
        else if (absA == 0) {
            return absB;
        }
        else if (absB == 0) {
            return absA;
        }
        else {
            while ((absA % absB) != 0) {
                temp = absA;
                absA = absB;
                absB = temp % absB;
            }
        }

        return absB;

    }

    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        else {
            return (Math.abs(a) / gcd(a, b)) * Math.abs(b);
        }
    }

    public static boolean areRelativelyPrime(int a, int b) {
        return (gcd(a, b) == 1);
    }

    public static int totient(int n) {
        int count = 0;

        for (int i = 1; i < n; i++) {
            if (areRelativelyPrime(i, n)) {
                count++;
            }
        }

        if (n == 1) return 1;
        else return count;
    }

    public static void main(String[] args) {

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        System.out.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
        System.out.println("lcm(" + a + ", " + b + ") = " + lcm(a, b));
        System.out
                .println("areRelativelyPrime(" + a + ", " + b + ") = " + areRelativelyPrime(a, b));
        System.out.println("totient(" + a + ") = " + totient(a));
        System.out.println("totient(" + b + ") = " + totient(b));
    }
}
