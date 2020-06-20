/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Course: Princeton: Computer Science: Programming with a Purpose
 *
 *  Compilation: javac-introcs RamanujanFinal.java
 *  Execution: java Ramanujan n
 *
 *  Purpose: An integer n is a Ramanujan number if can be expressed as the sum of
 *  two positive cubes in two different ways. That is, there are four distinct
 *  positive integers a, b, c, and d such that n=a^3+b^3=c^3+d^3.
 *  For example 1729=13+123=93+103. This program takes a long integer command-line
 *  argument n and prints true if it is a Ramanujan number, and false otherwise.
 *
 *  % java Ramanujan 1729
 *  true
 *  % java Ramanujan 9223278330318728221
 *  true
 *  % Ramanujan 3458
 *  false
 **************************************************************************** */

public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        int count = 0;
        long cubeRootOfN = (long) Math.cbrt(n);

        for (long a = 1; a <= cubeRootOfN; a++) {
            long a3 = a * a * a;
            double guessB = Math.cbrt(n - a3);

            if (count >= 2) {
                break;
            }

            if ((guessB % 1 == 0.0) && (guessB > a)) {
                count++;
            }

        }
        return count == 2;

    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {

        long n = Long.parseLong(args[0]);

        System.out.println(isRamanujan(n));

    }
}
