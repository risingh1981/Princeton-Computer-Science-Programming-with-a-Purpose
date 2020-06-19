/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Course: Princeton: Computer Science: Programming with a Purpose
 *
 *  Compilation: javac-introcs AudioCollage.java
 *  Execution: java-introcs AudioCollage
 *
 *  Purpose: This is a program that can be used to manipulate digital audio and
 *  to create an audio collage. The provided audio files represent sound as an
 *  array of real numbers between –1 and +1, with 44,100 samples per second. The
 *  functions provided below will allow one to amplify, reverse, merge, mix, and
 *  change the speed of *.wav files.
 **************************************************************************** */

public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] newArray = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            newArray[i] = a[i] * alpha;
        }
        return newArray;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] b = new double[a.length];
        int j = a.length;
        for (int i = 0; i < a.length; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
        return b;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] c = new double[a.length + b.length];
        for (int i = 0; i < c.length; i++) {
            if (i < a.length) {
                c[i] = a[i];
            }
            else {
                c[i] = b[i - a.length];
            }
        }
        return c;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        String larger;
        double[] c;
        if (a.length >= b.length) {
            c = new double[a.length];
            larger = "a";
        }
        else {
            c = new double[b.length];
            larger = "b";
        }


        // Run below conditional if a is larger
        if (larger.equals("a")) {
            for (int i = 0; i < a.length; i++) {
                if (i < b.length) {
                    c[i] = a[i] + b[i];
                }
                else {
                    c[i] = a[i];
                }
            }
        }
        else {
            for (int i = 0; i < b.length; i++) {
                if (i < a.length) {
                    c[i] = a[i] + b[i];
                }
                else {
                    c[i] = b[i];
                }
            }
        }
        return c;

    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int newLength = (int) Math.floor(a.length / alpha);
        double[] newArray = new double[newLength];

        for (int i = 0; i < newLength; i++) {
            newArray[i] = a[(int) Math.floor(i * alpha)];
        }

        return newArray;
    }

    public static void main(String[] args) {

        double[] amplify = amplify(StdAudio.read("beatbox.wav"), 2);
        double[] reverse = reverse(StdAudio.read("buzzer.wav"));
        double[] merge = merge(StdAudio.read("chimes.wav"), StdAudio.read("cow.wav"));
        double[] mix = mix(StdAudio.read("dialup.wav"), StdAudio.read("exposure.wav"));
        double[] newSpeed = changeSpeed(StdAudio.read("piano.wav"), 2);

        StdAudio.play(amplify);
        StdAudio.play(reverse);
        StdAudio.play(merge);
        StdAudio.play(mix);
        StdAudio.play(newSpeed);

    }
}
