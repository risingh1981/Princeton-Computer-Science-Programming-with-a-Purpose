/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Class:  Princeton: Computer Science: Programming with a Purpose
 *
 *  Compilation: javac GreatCircle.java
 *  Execution: java GreatCircle x1 y1 x2 y2
 *
 *  Purpose: The great-circle distance is the length of the shortest path
 *  between two points (x1,y1) and (x2,y2) on the surface of a sphere, where the
 *  path is constrained to be along the surface. This program takes four double
 *  command-line arguments x1, y1, x2, and y2—the latitude and longitude
 *  (in degrees) of two points on the surface of the earth—and prints the
 *  great-circle distance (in kilometers) between them using the Haversine
 *  formula.
 *
 *  % java GreatCircle 40.35 74.65 48.87 -2.33
 *  5902.927099258561 kilometers
 *
 *  java GreatCircle 60.0 15.0 120.0 105.0
 *  4604.53989281927 kilometers
 **************************************************************************** */

public class GreatCircle {
    public static void main(String[] args) {

        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double x2 = Double.parseDouble(args[2]);
        double y2 = Double.parseDouble(args[3]);

        double radx1 = Math.toRadians(x1);
        double rady1 = Math.toRadians(y1);
        double radx2 = Math.toRadians(x2);
        double rady2 = Math.toRadians(y2);

        // Radius of Earth in Kilometers.
        double r = 6371.0;

        double sqrt = Math.pow(Math.sin((radx2 - radx1) / 2), 2) + (Math.cos(radx1) * Math
                .cos(radx2) * Math.pow(Math.sin((rady2 - rady1) / 2), 2));

        double distance = 2 * r * Math.asin(Math.sqrt(sqrt));

        System.out.println(distance + " kilometers");
    }
}
