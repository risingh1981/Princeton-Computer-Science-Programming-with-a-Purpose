/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Course: Princeton: Computer Science: Programming with a Purpose
 *
 *  Compilation: javac BandMatrix.java
 *  Execution: java BandMatrix n width
 *
 *  Purpose: This takes two integer command-line arguments n and width and prints
 *  an n-by-n pattern like the ones below, with a zero (0) for each element
 *  whose distance from the main diagonal is strictly more than width, and an
 *  asterisk (*) for each entry that is not, and two spaces between each 0 or *.
 *
 *  % java BandMatrix 8 0
 *  *  0  0  0  0  0  0  0
 *  0  *  0  0  0  0  0  0
 *  0  0  *  0  0  0  0  0
 *  0  0  0  *  0  0  0  0
 *  0  0  0  0  *  0  0  0
 *  0  0  0  0  0  *  0  0
 *  0  0  0  0  0  0  *  0
 *  0  0  0  0  0  0  0  *
 *
 *  % java BandMatrix 10 3
 *  *  *  *  *  0  0  0  0  0  0
 *  *  *  *  *  *  0  0  0  0  0
 *  *  *  *  *  *  *  0  0  0  0
 *  *  *  *  *  *  *  *  0  0  0
 *  0  *  *  *  *  *  *  *  0  0
 *  0  0  *  *  *  *  *  *  *  0
 *  0  0  0  *  *  *  *  *  *  *
 *  0  0  0  0  *  *  *  *  *  *
 *  0  0  0  0  0  *  *  *  *  *
 *  0  0  0  0  0  0  *  *  *  *
 *
 **************************************************************************** */

public class BandMatrix {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]); // Dimensions n x n of matrix.
        int width = Integer.parseInt(args[1]); // Width of band matrix.


        for (int r = 0; r < n; r++) {

            for (int c = 0; c < n; c++) {
                if (Math.abs(r - c) <= width) System.out.print("*  ");
                else System.out.print("0  ");
            }

            // Print a new line
            System.out.println();
        }
    }


}

