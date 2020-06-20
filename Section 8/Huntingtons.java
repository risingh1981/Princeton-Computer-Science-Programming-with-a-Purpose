/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Course: Princeton: Computer Science: Programming with a Purpose
 *
 *  Compilation: javac-introcs Huntingtons.java
 *  Execution: java-introcs Huntingtons filename.txt
 *
 *  Purpose: Huntington’s disease is an inherited and fatal neurological disorder.
 *  Although there is currently no cure, in 1993 scientists discovered a very
 *  accurate genetic test. The gene that causes Huntington’s disease is located
 *  on chromosome 4 and has a variable number of (consecutive) repeats of the
 *  CAG trinucleotide. The normal range of CAG repeats is between 10 and 35.
 *  Individuals with Huntington’s disease have between 36 and 180 repeats.
 *  Doctors can use a PCR-based DNA test; count the maximum number of repeats;
 *  and use the following table to generate a diagnosis:
 *      repeats	diagnosis
 *      0–9	    not human
 *      10–35	normal
 *      36–39	high risk
 *      40–180  Huntington’s
 *  This program takes as input a *.txt file with a sequence of nucleotides
 *  (A, C, G, and T), with arbitrary amounts of whitespace separating the
 *  nucleotides.
 *  The output of the program is the medical diagnosis according to the input
 *  file.
 *
 *  % cat repeats64.txt
 *  TTTTTTTTTT TTTTTTTTTT TTTTTTTTTT TTTTTTTTTT TTTTTTTTTT TTCAGCAGCA
 *  GCAGCAGCAG CAGCAGCAGC AGCAGCAGCA GCAGCAGCAG CAGCAGCAGC AGCAGCAGCA
 *  GCAGCAGCAG CAGCAGCAGC AGCAGCAGCA GCAGCAGCAG CAGCAGCAGC AGCAGCAGCA
 *  GCAGCAGCAG CAGCAGCAGC AGCAGCAGCA GCAGCAGCAG CAGCAGCAGC AGCAGCAGCA
 *  GCAGTTTTTT TTTTTTTTTT TTTTTTTTTT TTTTTTTTTT TTTTTTTTTT TTTTTTTTTT
 *  % java-introcs Huntingtons repeats64.txt
 *  max repeats = 64
 *  Huntington's
 *
 *  % cat repeats4.txt
 *  TTTTTTTTTT TTTTTTTTTT TTTTTTTTCAGCAGCAGCAG TTTCAGCAGT TTTTTTTTTT
 *  TTTTTTTTTT TTTTTTTTTT TTTTTTTTTTTTTCAGTTTT TTTTTTTTTT T
 *  % java-introcs Huntingtons repeats4.txt
 *  max repeats = 4
 *  not human
 **************************************************************************** */

public class Huntingtons {


    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int count = 0;
        int index = 0;
        int maxCAG = 0;

        while (index <= dna.length() - 3) {
            if (!(dna.substring(index, index + 3).equals("CAG"))) {
                index = index + 1;
            }
            if (index <= dna.length() - 3) {
                while (dna.substring(index, index + 3).equals("CAG")) {
                    count++;
                    index = index + 3;
                    if (index > dna.length() - 3) break;
                }
            }
            if (count > maxCAG) {
                maxCAG = count;
            }
            count = 0;

        }

        return maxCAG;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        String withoutWhiteSpace = s.replace(" ", "");
        withoutWhiteSpace = withoutWhiteSpace.replace("\n", "");
        withoutWhiteSpace = withoutWhiteSpace.replace("\t", "");
        return withoutWhiteSpace;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        String diagnosis = "";
        if (maxRepeats >= 0 && maxRepeats <= 9) diagnosis = "not human";
        else if (maxRepeats >= 10 && maxRepeats <= 35) diagnosis = "normal";
        else if (maxRepeats >= 36 && maxRepeats <= 39) diagnosis = "high risk";
        else if (maxRepeats >= 40 && maxRepeats <= 180) diagnosis = "Huntington's";
        else if (maxRepeats >= 181) diagnosis = "not human";

        return diagnosis;
    }

    // Sample client
    public static void main(String[] args) {
        In in = new In(args[0]);
        String s = in.readAll();

        String dna = removeWhitespace(s);

        System.out.println("max repeats = " + maxRepeats(dna));
        System.out.println(diagnose(maxRepeats(dna)));
    }
}
