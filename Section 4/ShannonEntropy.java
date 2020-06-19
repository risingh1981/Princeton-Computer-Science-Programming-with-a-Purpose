/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Course: Princeton: Computer Science: Programming with a Purpose
 *
 *  Compilation: javac-introcs ShannonEntropy.java
 *  Execution: java-introcs ShannonEntropy m < filename.txt
 *
 *  Purpose: The Shannon entropy is a measure of the rate of information produced
 *  by a random source, such as the outcomes of flipping a fair coin or rolling a
 *  loaded die. It is a fundamental concept in information theory and data
 *  compression. This program takes a command-line integer m; reads a sequence of
 *  integers between 1 and m from standard input; and prints the Shannon entropy
 *  to standard output, with 4 digits after the decimal point.
 *  The Shannon entropy of a sequence of integers is given by the formula:
 *  H = - (p1*Log base 2(p1) + p2*Log base 2(p2) +...+ pm*Log base 2(pm)
 *  where pi denotes the proportion of integers whose value is i.
 *
 *  % cat loaded-die.txt
 *  2 6 2 4 3 2 1 2 2 1 3 2 3 2 2
 *  % java-introcs ShannonEntropy 6 < loaded-die.txt
 **************************************************************************** */

public class ShannonEntropy {
    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);
        int[] freq = new int[m + 1];
        int count = 0;

        while (!StdIn.isEmpty()) {
            int value = StdIn.readInt();
            if (value >= 1 && value <= m) {
                freq[value]++;
            }
            count++;
        }

        double entropy = 0.0;
        for (int i = 1; i <= m; i++) {
            double p = 1.0 * freq[i] / count;
            if (freq[i] > 0)
                // Math tip: you can evaluate a non-standard-base log by
                // converting it to the fraction of the form "(standard-base
                // log of the argument) divided by (same-standard-base log of
                // the non-standard-base).
                entropy -= p * Math.log(p) / Math.log(2);
        }

        StdOut.printf("%.4f%n", entropy);

    }

}

