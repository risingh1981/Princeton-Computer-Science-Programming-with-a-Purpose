/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Course: Princeton: Computer Science: Programming with a Purpose
 *
 *  Compilation: javac-introcs ColorHSB.java
 *  Execution: java-introcs ColorHSB h s b
 *
 *  Purpose: This program represents a data type that represents a color in
 *  hue–saturation–brightness (HSB) format. The HSB color format is widely used
 *  in color pickers.
 *  A color in HSB format is composed of three components:
 *  The hue is an integer between 0 and 359.
 *  The saturation is an integer between 0 and 100. It represents the purity of
 *  the hue.
 *  The brightness is an integer between 0 and 100. It represents the percentage
 *  of white that is mixed with the hue.
 *
 *  % java-introcs ColorHSB 25 84 97 < web.txt
 *  Red (0, 100, 100)
 *
 *  % java-introcs ColorHSB 25 84 97 < wiki.txt
 *  Princeton_Orange (26, 85, 96)
 **************************************************************************** */

public class ColorHSB {

    private final int hue, saturation, brightness;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if ((h < 0) || (h > 359) || (s < 0) || (s > 100) || (b < 0) || (b > 100)) {
            throw new IllegalArgumentException("Arguments are out of range");
        }

        hue = h;
        saturation = s;
        brightness = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hue + ", " + saturation + ", " + brightness + ")";
    }


    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return ((this.saturation == 0) || (this.brightness == 0));
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) {
            throw new IllegalArgumentException("Argument value is null");
        }
        return (int) (Math.min(Math.pow((this.hue - that.hue), 2),
                               Math.pow(360 - Math.abs((this.hue - that.hue)), 2)) +
                Math.pow((this.saturation - that.saturation), 2) +
                Math.pow((this.brightness - that.brightness), 2));
    }

    public static void main(String[] args) {

        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        ColorHSB inputColor = new ColorHSB(h, s, b);


        String colorName;
        String minColorName = "";
        ColorHSB minColor = new ColorHSB(0, 0, 0);
        int hFile;
        int sFile;
        int bFile;

        int minDistance = 360 * 360;

        while (!StdIn.isEmpty()) {
            colorName = StdIn.readString();
            hFile = StdIn.readInt();
            sFile = StdIn.readInt();
            bFile = StdIn.readInt();

            ColorHSB secondColor = new ColorHSB(hFile, sFile, bFile);
            if (inputColor.distanceSquaredTo(secondColor) < minDistance) {
                minDistance = inputColor.distanceSquaredTo(secondColor);
                minColor = new ColorHSB(hFile, sFile, bFile);
                minColorName = colorName;
            }
        }

        System.out.println(minColorName + " " + minColor.toString());


    }
}

