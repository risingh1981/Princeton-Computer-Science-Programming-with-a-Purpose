/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Course: Princeton: Computer Science: Programming with a Purpose
 *
 *  Compilation: javac-introcs BarChartRacer.java
 *  Execution: java-introcs BarChartRacer file.txt n
 *
 *  Purpose: This program produced animated bar charts using data from a data file
 *  and BarChart.java to draw static bar charts.
 **************************************************************************** */

import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[1]);
        String fileName = args[0];
        In in = new In(fileName);

        String title = in.readLine();
        String xAxis = in.readLine();
        String source = in.readLine();

        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        BarChart chart = new BarChart(title, xAxis, source);

        in.readLine();
        while (in.hasNextLine()) {
            int numberOfBars = Integer.parseInt(in.readLine());

            Bar[] bars = new Bar[numberOfBars];

            for (int i = 0; i < numberOfBars; i++) {
                String line = in.readLine();

                String[] parts = line
                        .split(","); //  format (date[0],name[1],associated country[2], value[3],category[4])
                bars[i] = new Bar(parts[1], Integer.parseInt(parts[3]), parts[4]);
                if (i == numberOfBars - 1) {
                    chart.setCaption(parts[0]);
                }
            }

            Arrays.sort(bars);

            for (int i = numberOfBars - 1; i >= numberOfBars - n; i--) {
                chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
            }

            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(3);
            in.readLine();

            chart.reset();
        }

    }
}
