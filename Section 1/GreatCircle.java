/* *****************************************************************************
 *  Name:              Ricky Singh
 *  Floating-point numbers and the Math library. The great-circle distance is
 * the length of the shortest path between two points (x1,y1) and (x2,y2) on
 * the surface of a sphere, where the path is constrained to be along the surface.
 * Write a program GreatCircle.java that takes four double command-line arguments
 * x1, y1, x2, and y2—the latitude and longitude (in degrees) of two points on
 * the surface of the earth—and prints the great-circle distance (in kilometers)
 * between them. Use the following Haversine formula
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

        double r = 6371.0;

        double sqrt = Math.pow(Math.sin((radx2 - radx1) / 2), 2) + (Math.cos(radx1) * Math
                .cos(radx2) * Math.pow(Math.sin((rady2 - rady1) / 2), 2));

        double distance = 2 * r * Math.asin(Math.sqrt(sqrt));

        System.out.println(distance + " kilometers");
    }
}
