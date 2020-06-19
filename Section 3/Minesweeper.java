/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Course: Princeton: Computer Science: Programming with a Purpose
 *
 *  Compilation: javac Minesweeper.java
 *  Execution: java Minesweeper m n k
 *
 *  Purpose: Minesweeper is a 1960s era video game played on an m-by-n grid of
 *  cells. The goal is to deduce which cells contain hidden mines using clues
 *  about the number of mines in neighboring cells. This program takes three
 *  integer command-line arguments m, n, and k and prints an m-by-n
 *  grid of cells with k mines, using asterisks for mines and integers for the
 *  neighboring mine counts (with two space characters between each cell). It
 *  generates an m-by-n grid of cells, with exactly k of the mn cells containing
 *  mines, uniformly at random.
 *  For each cell not containing a mine, the number of neighboring mines
 *  (above, below, left, right, or diagonal) is listed.
 *
 *  % java Minesweeper 9 9 10
 *  0  0  0  0  1  1  1  1  *
 *  0  0  0  1  2  *  1  1  1
 *  0  1  1  2  *  2  1  0  0
 *  0  1  *  3  2  1  0  0  0
 *  0  1  2  *  2  1  1  0  0
 *  1  1  2  1  3  *  2  0  0
 *  2  *  1  0  2  *  2  0  0
 *  *  2  1  1  2  2  1  0  0
 *  1  1  0  1  *  1  0  0  0
 *
 *
 ***************************************************************************** */

public class Minesweeper {
    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        // Use a grid that is bigger by two because we will be working on the
        // sub grid between the m values of 1 and m + 1 and between the n values
        // of 1 and n + 1 because it will make it easier constructing a nested
        // for loop when searching for number of mine around a certain box in the
        // grid for the corners and borders.
        int[][] grid = new int[m + 2][n + 2];

        int count = 0;
        int mRandom;
        int nRandom;
        while (count < k) {
            mRandom = (int) ((Math.random() * (m)) + 1);
            nRandom = (int) ((Math.random() * (n)) + 1);

            // If the randomly chosen square in the grid already has a mine,
            // decrement count by 1 as that is not a valid randomly chosen location.
            if (grid[mRandom][nRandom] == -1) {
                count--;
            }

            grid[mRandom][nRandom] = -1; // Set grid[mRandom][nRandom] to -1 to
            // signify that there is a mine there.
            count++;

        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // For each square in the grid, except those that contain a mine,
                // add up the number of surrounding mines.
                if (grid[i][j - 1] == -1 && grid[i][j] != -1) {
                    grid[i][j]++;
                }
                if (grid[i][j + 1] == -1 && grid[i][j] != -1) {
                    grid[i][j]++;
                }
                if (grid[i + 1][j] == -1 && grid[i][j] != -1) {
                    grid[i][j]++;
                }
                if (grid[i + 1][j + 1] == -1 && grid[i][j] != -1) {
                    grid[i][j]++;
                }
                if (grid[i + 1][j - 1] == -1 && grid[i][j] != -1) {
                    grid[i][j]++;
                }
                if (grid[i - 1][j] == -1 && grid[i][j] != -1) {
                    grid[i][j]++;
                }
                if (grid[i - 1][j + 1] == -1 && grid[i][j] != -1) {
                    grid[i][j]++;
                }
                if (grid[i - 1][j - 1] == -1 && grid[i][j] != -1) {
                    grid[i][j]++;
                }
            }
        }


        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (grid[i][j] == -1) System.out.print("*  ");
                else System.out.print(grid[i][j] + "  ");
            }
            System.out.println("");
        }
    }
}





