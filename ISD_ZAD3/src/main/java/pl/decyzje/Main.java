package pl.decyzje;

import java.nio.file.Path;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        TxtDocument document = new TxtDocument();

        double[][] matrix = document.getMatrix(Path.of("Documents/Good_Bad_Matrix.txt"));
        double[][] distanceMatrixEuclides = Euclides.euclidesDistanceMatrix(matrix);
        double[] test = MinValue.min_row(distanceMatrixEuclides);


        for (int i = 0; i < matrix.length; i++) {
            if (i == 0) {
                System.out.print("\nBad  ");
            }
            if (i == 1) {
                System.out.print("\nGood");
            }
            if (i == 2) {
                System.out.print("\nNeutral");
            }
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("\t           " + (int) matrix[i][j]);
            }
        }
        System.out.println("\n");

        System.out.println("Euclides:");
        for (int j = 0; j < distanceMatrixEuclides[0].length; j++) {

            System.out.print("\t              d" + (j));
        }
        for (int i = 0; i < distanceMatrixEuclides.length; i++) {
            System.out.print("\nd" + (i));
            for (int j = 0; j < distanceMatrixEuclides[i].length; j++) {
                System.out.print("\t            " + String.format("%.2f", distanceMatrixEuclides[i][j]));
            }
        }
        System.out.println("\n");

        System.out.print(String.format("%.2f", distanceMatrixEuclides[0][2])+" Is closer to Bad");

        System.out.println("\n");


        for (int i = 0; i < test.length; i++) {
            System.out.print("\t" + String.format("%.2f",test[i]));

        }

    }}