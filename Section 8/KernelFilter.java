/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Course: Princeton: Computer Science: Programming with a Purpose
 *
 *  Compilation: javac-introcs KernelFilter.java
 *  Execution: java-introcs KernelFilter image.png
 *
 *  Purpose: This program is an image-processing program that applies various
 *  kernel filters to images, such as Gaussian blur, sharpen, laplacian, emboss,
 *  and motion blur. A kernel filter modifies the pixels in an image by replacing
 *  each pixel with a linear combination of its neighboring pixels. The matrix
 *  that characterizes the linear combination is known as the kernel.
 *
 **************************************************************************** */

import java.awt.Color;

public class KernelFilter {

    private static int clamp(double n) {
        if (n < 0) return 0;
        if (n > 255) return 255;
        return (int) Math.round(n);
    }

    // Takes as parameters, a picture and a kernel matrix and returns a new picture
    // with the specified kernel matrix applied.
    private static Picture createNewPicture(Picture picture, double[][] kernel) {
        Picture newPicture = new Picture(picture.width(), picture.height());

        for (int column = 0; column < picture.width(); column++) {
            for (int row = 0; row < picture.height(); row++) {
                double sumRed = 0;
                double sumGreen = 0;
                double sumBlue = 0;
                int kernelSize = kernel.length;
                int center = kernelSize / 2;


                for (int i = 0; i < kernelSize; i++) {
                    for (int j = 0; j < kernelSize; j++) {

                        int effectiveColumn = Math.floorMod(column - center + i, picture.width());
                        int effectiveRow = Math.floorMod(row - center + j, picture.height());

                        Color color = picture.get(effectiveColumn, effectiveRow);

                        int red = color.getRed();
                        int green = color.getGreen();
                        int blue = color.getBlue();
                        sumRed += red * kernel[i][j];
                        sumGreen += green * kernel[i][j];
                        sumBlue += blue * kernel[i][j];
                    }
                }

                Color pixel = new Color(clamp(sumRed), clamp(sumGreen), clamp(sumBlue));
                newPicture.set(column, row, pixel);
            }
        }
        return newPicture;
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[][] kernel = {
                { (double) 1 / 16, (double) 2 / 16, (double) 1 / 16 },
                { (double) 2 / 16, (double) 4 / 16, (double) 2 / 16 },
                { (double) 1 / 16, (double) 2 / 16, (double) 1 / 16 },
                };

        return createNewPicture(picture, kernel);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] kernel = {
                { 0, -1, 0 },
                { -1, 5, -1 },
                { 0, -1, 0 },
                };

        return createNewPicture(picture, kernel);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] kernel = {
                { -1, -1, -1 },
                { -1, 8, -1 },
                { -1, -1, -1 },
                };

        return createNewPicture(picture, kernel);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] kernel = {
                { -2, -1, 0 },
                { -1, 1, 1 },
                { 0, 1, 2 },
                };

        return createNewPicture(picture, kernel);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] kernel = {
                { (double) 1 / 9, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, (double) 1 / 9, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, (double) 1 / 9, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, (double) 1 / 9, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, (double) 1 / 9, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, (double) 1 / 9, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, (double) 1 / 9, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, (double) 1 / 9, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, (double) 1 / 9 },
                };

        return createNewPicture(picture, kernel);
    }

    // Test client (ungraded).
    public static void main(String[] args) {

        String file = args[0];

        Picture original = new Picture(file);

        Picture gaussian = gaussian(original);
        Picture sharpen = sharpen(original);
        Picture laplacian = laplacian(original);
        Picture emboss = emboss(original);
        Picture motion = motionBlur(original);

        gaussian.show();
        sharpen.show();
        laplacian.show();
        emboss.show();
        motion.show();


    }
}
