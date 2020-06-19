/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Course: Princeton: Computer Science: Programming with a Purpose
 *
 *  Compilation: javac ThueMorse.java
 *  Execution: java Thuemorse n
 *
 *  Purpose: This program an integer command-line argument n and prints an
 *  n-by-n pattern like the ones shown below based on the Thue-Morse sequence.
 *  It creates an n-by-n pattern by printing a + (plus sign) in row i and column
 *  j if bits i and j in the sequence are *  equal, and a - (minus sign) if they
 *  are different. There are two space characters between each + and - character.
 *  The Thue–Morse sequence is an infinite sequence of 0s and 1s that is
 *  constructed by starting with 0 and successively appending the bitwise
 *  negation (interchange 0s and 1s) of the existing sequence. Here are the
 *  first few steps of this construction:
 *  0
 *  01
 *  0110
 *  01101001
 *  0110100110010110
 *
 *
 *  % java ThueMorse 5
 *  +  -  -  +  -
 *  -  +  +  -  +
 *  -  +  +  -  +
 *  +  -  -  +  -
 *  -  +  +  -  +
 *
 *  % java ThueMorse 8
 *  +  -  -  +  -  +  +  -
 *  -  +  +  -  +  -  -  +
 *  -  +  +  -  +  -  -  +
 *  +  -  -  +  -  +  +  -
 *  -  +  +  -  +  -  -  +
 *  +  -  -  +  -  +  +  -
 *  +  -  -  +  -  +  +  -
 *  -  +  +  -  +  -  -  +
 **************************************************************************** */

public class ThueMorse {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int[] thue = new int[n];

        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) thue[i] = thue[i / 2];
            else thue[i] = 1 - thue[i - 1];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (thue[i] == thue[j]) {
                    System.out.print("+  ");
                }
                else {
                    System.out.print("-  ");
                }
            }
            System.out.println();
        }

    }
}
