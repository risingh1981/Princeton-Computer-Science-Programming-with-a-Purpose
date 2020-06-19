/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Course: Princeton: Computer Science: Programming with a Purpose
 *
 *  Compilation: javac Birthday.java
 *  Execution: java Birthday n trials
 *
 *  Purpose: This is a program that takes two integer command-line arguments n
 *  and trials and performs the following experiment, trials times:
 *  Chooses a birthday for the next person, uniformly at random between 0 and n−1.
 *  Have that person enter the room. If that person shares a birthday with someone
 *  else in the room, stop; otherwise repeat. Suppose that people enter the room
 *  one at a time.
 *
 *  In each experiment, it counts the number of people that enter the room.
 *  It prints a table that summarizes the results (the count i, the number of times
 *  that exactly i people enter the room, and the fraction of times that i or
 *  fewer people enter the room) for each possible value of i from 1 until the
 *  fraction reaches (or exceeds) 50%.
 *
 *  % java Birthday 31 1000000
 *  1	0	    0.0
 *  2	32270	0.03227
 *  3	62580	0.09485
 *  4	87582	0.182432
 *  5	105596	0.288028
 *  6	114427	0.402455
 *  7	115494	0.517949
 **************************************************************************** */

import java.util.ArrayList;

public class Birthday {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        int[] guestsPerTrial = new int[trials];

        // Conduction trials number of trials where you randomly pick a birthday
        // between 0 and n-1 and keep picking a birthday till you pick a birthday
        // you have already seen.  Store the random birthdays you pick in ArrayList
        // bdays.
        // If you pick a repeated birthday, store the size of bdays + 1 into
        // guestsPerTrial[i].
        for (int i = 0; i < trials; i++) {

            ArrayList<Integer> bdays = new ArrayList<Integer>();

            boolean test = true;
            while (test) {
                int randomBday = (int) (Math.random() * (n));
                for (int j = 0; j < bdays.size(); j++) {
                    if (randomBday == bdays.get(j)) {
                        guestsPerTrial[i] = bdays.size() + 1;
                        test = false;
                        break;
                    }
                }
                bdays.add(randomBday);

            }


        }

        int count = 1;
        double fraction = 0.0;

        while (fraction < 0.5) {

            int repeats = 0;
            for (int k = 0; k < trials; k++) {
                if (guestsPerTrial[k] == count) {
                    repeats++;
                }
            }

            fraction += (double) repeats / trials;


            String format = "%-6d%-10d%f%n";
            System.out.printf(format, count, repeats, fraction);

            count++;

        }
    }
}
