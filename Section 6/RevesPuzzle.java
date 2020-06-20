/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Course: Princeton: Computer Science: Programming with a Purpose
 *
 *  Compilation: javac-introcs RevesPuzzle.java
 *  Execution: java-introcs RevesPuzzle n
 *
 *  Purpose: This program solves the puzzle from towers of Hanoi problem, except
 *  that this does it for 4 poles instead of 3. The task is to move n discs of
 *  different sizes from the starting pole to the destination pole, while obeying
 *  the following rules:
 *   - Move only one disc at a time.
 *   - Never place a larger disc on a smaller one.
 *  The algorithm used is the one discovered by Frame and Stewart in 1941:
 *   - Let k denote the integer nearest to n+1-sqrt(2n+1)
 *   - Transfer (recursively) the k smallest discs to a single pole other than
 *     the start or destination poles.
 *   - Transfer the remaining n−k disks to the destination pole (without using
 *     the pole that now contains the smallest k discs). To do so, use the
 *     algorithm for the 3-pole towers of Hanoi problem.
 *   - Transfer (recursively) the k smallest discs to the destination pole.
 *
 *  % java-introcs RevesPuzzle 4
 *  Move disc 1 from A to D
 *  Move disc 2 from A to B
 *  Move disc 1 from D to B
 *  Move disc 3 from A to C
 *  Move disc 4 from A to D
 *  Move disc 3 from C to D
 *  Move disc 1 from B to A
 *  Move disc 2 from B to D
 *  Move disc 1 from A to D
 **************************************************************************** */

public class RevesPuzzle {
    private static void fourHanoi(int n, String from, String aux1, String aux2, String to) {

        if (n == 0) return;
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));


        fourHanoi(k, from, to, aux2, aux1);

        hanoi(n, k, from, aux2, to);

        fourHanoi(k, aux1, from, aux2, to);

    }

    private static void hanoi(int n, int k, String from, String aux, String to) {

        if (n == k) return;
        hanoi(n - 1, k, from, to, aux);
        System.out.println("Move disc " + n + " from " + from + " to " + to);
        hanoi(n - 1, k, aux, from, to);

    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        fourHanoi(n, "A", "B", "C", "D");

    }
}

