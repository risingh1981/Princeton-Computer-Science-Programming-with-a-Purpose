/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Course: Princeton: Computer Science: Programming with a Purpose
 *
 *  Compilation: javac-introcs WorldMap.java
 *  Execution: java-introcs WorldMap < filename.txt
 *
 *  Purpose:  This is a program that reads boundary information of a country
 *  (or other geographic entity) from standard input and plots the results to
 *  standard drawing. A country consists of a set of regions (e.g., states,
 *  provinces, or other administrative divisions), each of which is described by
 *  a polygon.
 *  Input Format: The first line contains two integers: width and height. The
 *  remaining part of the input is divided into regions. The first entry in each
 *  region is the name of the region. For simplicity, names will not contain
 *  spaces. The next entry is an integer specifying the number of vertices in
 *  the polygon describing the region.
 *  Finally, the region contains the x- and y-coordinates of the vertices of the
 *  polygon.
 **************************************************************************** */

public class WorldMap {
    public static void main(String[] args) {


        int width = StdIn.readInt();
        int height = StdIn.readInt();

        double ZERO = 0.0;

        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(ZERO, width);
        StdDraw.setYscale(ZERO, height);

        while (!StdIn.isEmpty()) {
            String region = StdIn.readString();
            int numVertices = StdIn.readInt();
            double[] xVertex = new double[numVertices];
            double[] yVertex = new double[numVertices];

            for (int i = 0; i < numVertices; i++) {
                xVertex[i] = StdIn.readDouble();
                yVertex[i] = StdIn.readDouble();
            }
            StdDraw.polygon(xVertex, yVertex);
        }
        StdDraw.show();
    }
}
