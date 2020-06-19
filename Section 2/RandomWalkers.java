/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Course: Princeton: Programming with a Purpose
 *
 *  Compilation: javac RandomWalkers.java
 *  Execution: java RandomWalkers r trials
 *
 *  Purpose: This program takes two integer command-line arguments r and trials.
 *  In each of trials independent experiments, simulate a random walk until the
 *  random walker is at Manhattan distance r from the starting point. Print the
 *  average number of steps.
 *
 *  % java RandomWalkers 5 1000000
 *  average number of steps = 14.967998
 *
 *  % java RandomWalkers 10 100000
 *  average number of steps = 59.16106
 *
 *  % java RandomWalkers 80 100000
 *  average number of steps = 3757.45922
 **************************************************************************** */

public class RandomWalkers {
    public static void main(String[] args) {

        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int x = 0;
        int y = 0;
        int x1;
        int y1;
        double random;
        int steps = 0;

        for (int i = 1; i <= trials; i++) {
            x1 = 0;
            y1 = 0;
            while ((Math.abs(x - x1) + Math.abs(y - y1)) != r) {
                random = Math.random();
                if (random <= 0.25) x1++;
                else if (random <= 0.5) x1--;
                else if (random <= 0.75) y1++;
                else if (random <= 1.0) y1--;
                steps++;
            }
        }
        double averageSteps = (double) steps / trials;
        System.out.println("average number of steps = " + averageSteps);

    }
}
