/* *****************************************************************************
 *  Name:              Ricky Singh
 * Integers and booleans. Write a program RightTriangle that takes three int
 * command-line arguments and determines whether they constitute the side
 * lengths of some right triangle.
 **************************************************************************** */

public class RightTriangle {
    public static void main(String[] args) {
        // Checks if a right triangle with three command line arguments
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        int max = Integer.MAX_VALUE;
        boolean test =
                ((a > 0) && (b > 0) && (c > 0) && (((a * a) + (b * b)) == (c * c)) && (a < max) && (
                        b < max) && (c < max)) || ((a > 0) && (b > 0) && (c > 0) && (
                        ((a * a) + (c * c)) == (b * b)) && (a < max) && (b < max) && (c < max)) || (
                        (a > 0) && (b > 0) && (c > 0) && (((c * c) + (b * b)) == (a * a)) && (a
                                < max) && (b < max) && (c < max));

        System.out.println(test);
    }
}
