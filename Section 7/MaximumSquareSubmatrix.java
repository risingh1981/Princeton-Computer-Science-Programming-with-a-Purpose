/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Course: Princeton: Computer Science: Programming with a Purpose
 *
 *  Compilation: javac-introcs MaximumSquareSubmatrix.java
 *  Execution: java-introcs MaximumSquareSubmatrix < file.txt
 *
 *  Purpose: This program takes as input a n-by-n matrix of 0s and 1s, and finds
 *  a contiguous square submatrix of maximum size that contains only 1s
 *  Algorithm provided on Geeksforgeeks website.
 *  https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 *
 *  % cat square7.txt
 *  7
 *  0  1  1  0  1  1  1
 *  1  1  0  1  1  1  1
 *  0  1  1  1  1  1  1
 *  1  1  1  1  1  0  1
 *  1  1  1  1  1  1  0
 *  1  1  1  1  0  1  1
 *  1  1  1  1  0  1  1
 *
 *  % java-introcs MaximumSquareSubmatrix < square7.txt
 *  4
 *
 **************************************************************************** */

public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int rows = a.length;
        int columns = a[0].length;

        int[][] sizeMatrix = new int[rows][columns];

        int maximum = 0;

        // Copy first row of a[][] to sizeMatrix[][]
        for (int i = 0; i < rows; i++) {
            sizeMatrix[0][i] = a[0][i];
            if (a[0][i] > maximum) {
                maximum = a[0][i];
            }
        }
        // Copy first column of a[]][] to sizeMatrix[][].
        for (int j = 0; j < columns; j++) {
            sizeMatrix[j][0] = a[j][0];

            if (a[j][0] > maximum) {
                maximum = a[j][0];
            }
        }

        // Calculate other entries for sizeMatrix[][].
        // If a[i][j] = 0, then sizeMatrix[i][j] = 0
        // else if a[i][j] = 1; then sizeMatrix[i][j] =
        // Min(a[i-1][j],a[i-1][j-1],a[i][j-1].
        // Store value of entry to sizeMatrix as max if its max seen thus far.
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (a[i][j] == 0) {
                    sizeMatrix[i][j] = 0;
                }
                else if (a[i][j] == 1) {
                    sizeMatrix[i][j] =
                            Math.min(Math.min(sizeMatrix[i - 1][j], sizeMatrix[i - 1][j - 1]),
                                     sizeMatrix[i][j - 1])
                                    + 1;

                }

                if (sizeMatrix[i][j] > maximum) {
                    maximum = sizeMatrix[i][j];
                }

            }
        }

        // Return maximum value for sizeMatrix[i][j].
        return maximum;
    }


    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int sizeofArray = StdIn.readInt();
        int[][] array = new int[sizeofArray][sizeofArray];

        for (int i = 0; i < sizeofArray; i++) {
            for (int j = 0; j < sizeofArray; j++) {
                array[i][j] = StdIn.readInt();
            }
        }

        System.out.println(size(array));
    }
}
