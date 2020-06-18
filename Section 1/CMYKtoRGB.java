/* *****************************************************************************
 *  Name:              Ricky Singh
 *  Several different formats are used to represent color. For example, the
 * primary format for LCD displays, digital cameras, and web pages—known as the
 * RGB format—specifies the level of red (R), green (G), and blue (B) on an
 * integer scale from 0 to 255. The primary format for publishing books and
 * magazines—known as the CMYK format—specifies the level of cyan (C),
 * magenta (M), yellow (Y), and black (K) on a real scale from 0.0 to 1.0.
 * Write a program CMYKtoRGB.java that converts from CMYK format to RGB format
 * using these mathematical formulas:
 * white =1−black
 * red =255×white×(1−cyan)
 * green =255×white×(1−magenta)
 * blue =255×white×(1−yellow)
 * Your program must take four double command-line arguments cyan, magenta,
 * yellow, and black; compute the corresponding RGB values, each rounded to the
 * nearest integer; and print the RGB values, as in the example shown online.
 **************************************************************************** */

public class CMYKtoRGB {
    public static void main(String[] args) {

        double cyan = Double.parseDouble(args[0]);
        double magenta = Double.parseDouble(args[1]);
        double yellow = Double.parseDouble(args[2]);
        double black = Double.parseDouble(args[3]);

        double white = 1 - black;
        double red = 255 * white * (1 - cyan);
        double green = 255 * white * (1 - magenta);
        double blue = 255 * white * (1 - yellow);

        int intRed = (int) Math.round(red);
        int intGreen = (int) Math.round(green);
        int intBlue = (int) Math.round(blue);

        System.out.println("red   = " + intRed);
        System.out.println("green = " + intGreen);
        System.out.println("blue  = " + intBlue);

    }
}
