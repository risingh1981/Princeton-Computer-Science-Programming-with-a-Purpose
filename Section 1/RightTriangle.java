/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Class:  Princeton: Computer Science: Programming with a Purpose
 *
 *  Compilation: javac RightTriangle.java
 *  Execution: java RightTriangle num1 num2 num3
 *
 *  Purpose: This is a program that takes three int command-line arguments and
 * determines whether they constitute the side lengths of some right triangle.
 * You may not use any loops in this program
 *
 * % java RightTriangle 13 12 5
 * true
 *
 * % java RightTriangle 1 2 3
 * false
 **************************************************************************** */

public class RightTriangle {
    public static void main(String[] args) {
        // Checks if the arguments comprise the sides of a right triangle.
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));

        // Figure out which one is mid
        int mid = (a + b + c) - max - min;

        boolean test = (((min * min) + (mid * mid)) == (max * max)) && ((min > 0) && (mid > 0) && (
                max > 0));
        /* Another Implementation without determining maximum/minimum.
            int max = Integer.MAX_VALUE;
            boolean test =
                ((a > 0) && (b > 0) && (c > 0) && (((a * a) + (b * b)) == (c * c)) && (a < max) && (
                        b < max) && (c < max)) || ((a > 0) && (b > 0) && (c > 0) && (
                        ((a * a) + (c * c)) == (b * b)) && (a < max) && (b < max) && (c < max)) || (
                        (a > 0) && (b > 0) && (c > 0) && (((c * c) + (b * b)) == (a * a)) && (a
                                < max) && (b < max) && (c < max));
        */
        System.out.println(test);
    }
}
