/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Class:  Princeton: Computer Science: Programming with a Purpose
 *
 *  Compilation: javac HelloGoodbye.java
 *  Execution: java HelloGoodbye name1 name2
 *
 *  Purpose: Takes two names as command-line arguments and prints Hello and
 *  Goodbye messages with the names from the command-line arguments.  The names
 *  for the Hello message are in the same order as the command-line arguments
 *  and the names for the Goodbye message are in reverse order.
 *
 *  % java HelloGoodbye Kevin Bob
 *  Hello Kevin and Bob.
 *  Goodbye Bob and Kevin.
 **************************************************************************** */

public class HelloGoodbye {
    public static void main(String[] args) {
        System.out.println("Hello " + args[0] + " and " + args[1] + ".");
        System.out.println("Goodbye " + args[1] + " and " + args[0] + ".");

    }
}
