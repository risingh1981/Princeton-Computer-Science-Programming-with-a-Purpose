/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Course: Princeton: Computer Science: Programming with a Purpose
 *
 *  Compilation: javac Checkerboard.java
 *  Execution: java Checkerboard n
 *
 *  Purpose: This program takes a command-line integer n and plots an n-by-n
 *  checkerboard pattern to standard drawing. It colors the squares
 *  blue and light gray, with the bottom-left square blue.
 **************************************************************************** */

public class Checkerboard {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, n);

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if ((x + y) % 2 != 0) {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                }
                else {
                    StdDraw.setPenColor(StdDraw.BLUE);
                }
                StdDraw.filledSquare(x + 0.5, y + 0.5, 0.5);
            }
        }

    }
}

