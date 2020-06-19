/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Course: Princeton: Computer Science: Programming with a Purpose
 *
 *  Compilation: javac-introcs ActivationFunction.java
 *  Execution: java-introcs ActivationFunction input
 *
 *  Purpose: This program computes various activation functions that arise in
 *  neural networks. An activation function is a function that maps real numbers
 *  into a desired range, such as between 0 and 1 or between –1 and +1.
 *
 *  % java-introcs ActivationFunction -0.5
 *     heaviside(-0.5) = 0.0
 *       sigmoid(-0.5) = 0.377540668798145
 *          tanh(-0.5) = -0.462117157260009
 *      softsign(-0.5) = -0.3333333333333333
 *          sqnl(-0.5) = -0.4375
 **************************************************************************** */

public class ActivationFunction {
    public static double heaviside(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }
        else if (x < 0) {
            return 0.0;
        }
        else if (x == 0.0) {
            return 0.5;
        }
        else {
            return 1.0;
        }
    }

    public static double sigmoid(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }
        else {
            return (1 / (1 + Math.exp(-x)));
        }
    }

    public static double tanh(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }
        else if (x >= 20) {
            return 1.0;
        }
        else if (x <= -20) {
            return -1.0;
        }
        else {
            return ((Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x)));
        }
    }

    public static double softsign(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }
        else if (x == Double.POSITIVE_INFINITY) {
            return 1.0;
        }
        else if (x == Double.NEGATIVE_INFINITY) {
            return -1.0;
        }
        else {
            return (x / (1 + Math.abs(x)));
        }
    }

    public static double sqnl(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }
        else {
            if (x <= -2) return -1.0;
            else if (x > -2.0 && x < 0.0) return (x + ((x * x) / 4.0));
            else if (x < 2.0 && x >= 0.0) return (x - ((x * x) / 4.0));
            else return 1.0;
        }
    }

    public static void main(String[] args) {

        double input = Double.parseDouble(args[0]);

        StdOut.printf("%20s", "heaviside(" + input + ") = ");
        System.out.println(heaviside(input));
        StdOut.printf("%20s", "sigmoid(" + input + ") = ");
        System.out.println(sigmoid(input));
        StdOut.printf("%20s", "tanh(" + input + ") = ");
        System.out.println(tanh(input));
        StdOut.printf("%20s", "softsign(" + input + ") = ");
        System.out.println(softsign(input));
        StdOut.printf("%20s", "sqnl(" + input + ") = ");
        System.out.println(sqnl(input));


    }
}
