/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Course: Princeton: Computer Science: Programming with a Purpose
 *
 *  Compilation: javac-introcs Inversions.java
 *  Execution: java Inversions n k
 *
 *  Purpose:  This program takes integer n and a long k as command-line arguments,
 *  and can generate a permutation of length n with exactly k inversions and can
 *  count the number of inversions in a permutation array.
 *  Given an array of integers, a pair of elements a[i] and a[j] are inverted if
 *  i < j and a[i] > a[j].
 *  The purpose of this program is to test if you can implement these functions
 *  with performance in mind. The count() method should take time proportional to
 *  n^2 in the worst case. The generate() method should take time proportional to
 *  n in the worst case.
 *  It is assumed that the arguments to generate() satsify n≥0 and 0≤k≤(1/2)n(n−1);
 *  this guarantees the existence of a permutation of length n with exactly k
 *  inversions.
 *
 *  % java Inversions 10 20
 *  9 8 0 1 2 3 7 4 5 6
 *
 *  % java Inversions 10 45
 *  9 8 7 6 5 4 3 2 1 0
 *
 *  % java Inversions 10 0
 *  0 1 2 3 4 5 6 7 8 9
 **************************************************************************** */

public class Inversions {
    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        int length = a.length;
        long count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (a[i] >= a[j]) count++;
            }
        }
        return count;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] array = new int[n];
        int[] newArray = new int[n];
        if (n == 0) return array;
        // Generate array array[i] to contain values {0,1,2,...,n-1}
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        // If the number of desired inversions is less than n-1. Just move the
        // digit in array[n-1] (last digit) to newArray[n - k - 1]. Then move digits
        // in array [0] to [n-k-2] to newArray [0] to [n-k-2] and in array [n-k-1] to
        // [n-2] to newArray [n-k] to [n-1].
        if (k < n - 1) {
            newArray[(int) (n - k - 1)] = array[n - 1];
            for (int i = 0; i < (int) (n - k - 1); i++) {
                newArray[i] = array[i];
            }
            for (int i = (int) (n - k); i < n; i++) {
                newArray[i] = array[i - 1];
            }
        }
        long inversions = n - 1;
        long remaining = k;
        int beginning = 0;
        int ending = n - 1;

        if (k >= n - 1) {
            while (inversions < remaining) {
                if (beginning != n) {
                    newArray[beginning] = array[ending];
                }
                beginning++;
                inversions += n - beginning - 1;
                ending--;
            }
        }
        inversions = inversions - n + beginning + 1;
        newArray[(int) (n - (remaining - inversions) - 1)] = array[ending];
        int marker = 0;
        for (int i = beginning; i < n - (remaining - inversions) - 1; i++) {
            newArray[i] = array[marker];
            marker++;
        }
        for (int i = (int) (n - (remaining - inversions)); i < n; i++) {
            newArray[i] = array[marker];
            marker++;
        }

        return newArray;

    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        int[] finalArray;
        finalArray = generate(n, k);

        for (int i = 0; i < n; i++) {
            System.out.print(finalArray[i] + " ");
        }
        System.out.println();

    }
}
