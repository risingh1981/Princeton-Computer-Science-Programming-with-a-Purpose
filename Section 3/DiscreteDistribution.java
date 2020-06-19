/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Course: Princeton: Computer Science: Programming with a Purpose
 *
 *  Compilation: javac DiscreteDistribution.java
 *  Execution: java DiscreteDistribution m a1 a2 a3 a4 an
 *
 *  Purpose: This program takes an integer command-line argument m, followed by
 *  a sequence of positive integer command-line arguments a1,a2,…,an, and prints
 *  m random indices (separated by whitespace), choosing each index i with probability
 *  proportional to ai.
 *
 *  % java DiscreteDistribution 25 1 1 1 1 1 1
 *  6 3 2 5 3 6 5 4 4 5 2 2 3 1 3 3 1 2 4 2 1 4 4 3 1
 *
 *  % java DiscreteDistribution 100 301 176 125 97 79 67 58 51 46
 *  1 1 2 1 3 4 4 6 6 1 8 3 1 6 1 2 2 1 6 3 1 3 2 6 1
 *  2 9 1 4 1 3 9 3 1 6 1 5 2 1 6 1 3 3 1 2 7 3 1 1 4
 *  2 9 1 3 5 1 1 9 1 4 1 1 1 1 1 1 2 3 4 6 1 5 8 2 1
 *  8 9 7 8 9 4 1 6 1 1 5 8 5 5 5 6 2 1 3 8 1 7 5 8 2
 *
 **************************************************************************** */

public class DiscreteDistribution {
    public static void main(String[] args) {
        int n = args.length - 1;
        // System.out.println(n);
        int m = Integer.parseInt(args[0]);
        int total = 0;
        int[] arguments = new int[n];
        for (int i = 1; i <= n; i++) {
            arguments[i - 1] = Integer.parseInt(args[i]);
            total += arguments[i - 1];
        }

        int r;
        for (int j = 0; j < m; j++) {
            r = (int) (total * Math.random());
            int p = 0;
            int min = 0;
            while (r >= min) {
                min += arguments[p];
                p++;
            }
            // This is to print to a new line once previous line has 25 entries.
            if ((j != 0) && (j % 25 == 0)) {
                System.out.println();
            }
            System.out.print(p + " ");

        }
        System.out.println();
    }
}
