/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Course: Princeton: Computer Science: Programming with a Purpose
 *
 *  Compilation: javac-introcs TrinomialDP.java
 *  Execution: java TrinomialDP
 *
 *  Purpose: This program takes two integers n and k and computes the corresponding
 *  trinomial coefficient using dynamic programming. It does so by creating a
 *  Pascals triangle in an array.
 *  The trinomial coefficient T(n,k) is the coefficient of x^(n+k) in the
 *  expansion of (1+x+x2)^n.
 **************************************************************************** */

public class TrinomialDP {

    public static long trinomial(int n, int k) {
        if ((n == 0) && (k == 0)) return 1;
        if ((k < -n) || (k > n)) return 0;
        long[][] array = new long[n + 1][2 * n + 1];
        array[0][0] = 1;
        array[1][0] = 1;
        array[1][1] = 1;
        array[1][2] = 1;

        for (int i = 2; i <= n; i++) {

            for (int j = 0; j < 2 * i + 1; j++) {
                if (j == 0) {
                    array[i][j] = array[i - 1][0];
                }
                else if (j == 1) {
                    array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
                }
                else if (j == 2 * i) {
                    array[i][j] = array[i - 1][j - 2];
                }
                else if (j == 2 * i - 1) {
                    array[i][j] = array[i - 1][j - 1] + array[i - 1][j - 2];
                }
                else {
                    array[i][j] = array[i - 1][j] + array[i - 1][j - 1] + array[i - 1][j - 2];
                }

            }
        }

        return array[n][n + k];

    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        StdOut.println(trinomial(n, k));


    }
}
