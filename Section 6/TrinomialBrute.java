/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Course: Princeton: Computer Science: Programming with a Purpose
 *
 *  Compilation: javac-introcs TrinomialBrute.java
 *  Execution: java-introcs TrinomialBrute n k
 *
 *  Purpose: This program takes two integer command-line arguments n and k and
 *  computes the corresponding trinomial coefficient using recursion.
 *  The trinomial coefficient T(n,k) is the coefficient of x^(n+k) in the
 *  expansion of (1+x+x2)^n.
 *
 *  % java TrinomialBrute 24 12
 *  287134346
 *
 *  % java-introcs TrinomialBrute 3 1
 *  6
 **************************************************************************** */

public class TrinomialBrute {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if ((n == 0) && (k == 0)) return 1;
        if ((k < (-1) * n) || (k > n)) return 0;

        return (trinomial(n - 1, k - 1) + trinomial(n - 1, k) + trinomial(n - 1, k + 1));
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        StdOut.println(trinomial(n, k));
    }
}
