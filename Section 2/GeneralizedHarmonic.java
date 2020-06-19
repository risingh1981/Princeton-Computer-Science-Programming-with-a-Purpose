/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Course: Princeton: Computer Science: Programming with a Purpose
 *
 *  Compilation: javac GeneralizedHarmonic.java
 *  Execution: java GeneralizedHarmonic n r
 *
 *  Purpose: This program calculates the nth generalized harmonic number of order
 *  r using a for loop.  It takes two integer command-line arguments n and r and
 *  calculates the nth generalized harmonic number of order r using the following
 *  formula:
 *  H(n,r) = (1/(1^r)+1/(2^r)+ ... + 1/(n^r))
 *
 *  % java GeneralizedHarmonic 1 1
 *  1.0
 *
 *  % java GeneralizedHarmonic 3 1
 *  1.8333333333333333
 *
 *  % java GeneralizedHarmonic 2 2
 *  1.25
 *
 **************************************************************************** */

public class GeneralizedHarmonic {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);
        double harmonic = 0;

        for (int i = 1; i <= n; i++) {
            harmonic = harmonic + (1 / Math.pow(i, r));
        }
        System.out.println(harmonic);
    }
}
