/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Course: Princeton: Computer Science: Programming with a Purpose
 *
 *  Compilation: javac RandomWalker.java
 *  Execution: java RandomWalker r
 *
 *  Purpose:  This program takes an integer command-line argument r and simulates
 *  the motion of a random walk until the random walker is at Manhattan distance
 *  r from the starting point. It also prints the coordinates at each step of the
 *  walk (including the starting and ending points), treating the starting point
 *  as (0, 0). It also, prints the total number of steps taken.
 *
 *  % java RandomWalker 5
 *  (0, 0)
 *  (0, -1)
 *  (0, 0)
 *  (1, 0)
 *  (2, 0)
 *  (3, 0)
 *  (3, -1)
 *  (4, -1)
 *  steps = 7
 *
 **************************************************************************** */

public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);

        int x = 0;
        int y = 0;
        int steps = 0;
        double randomNumber;

        System.out.println("(" + x + ", " + y + ")");
        while ((Math.abs(x) + Math.abs(y)) != r) {
            steps++;
            randomNumber = Math.random();
            if (randomNumber <= 0.25) x++;
            else if (randomNumber <= 0.50) x--;
            else if (randomNumber <= 0.75) y++;
            else if (randomNumber <= 1.00) y--;
            System.out.println("(" + x + ", " + y + ")");
        }
        System.out.println("steps = " + steps);
    }
}
