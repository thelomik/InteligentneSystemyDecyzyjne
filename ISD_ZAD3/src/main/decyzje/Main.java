package pl.decyzje;

import com.google.common.collect.Lists;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

import static pl.decyzje.Czebyszew.czebyszewDistanceMatrix;
import static pl.decyzje.Euclides.euclidesDistanceMatrix;
import static pl.decyzje.Manhattan.manhattanDistanceMatrix;


public class Main {


    public static void main(String[] args) {

        TxtDocument document = new TxtDocument();

        ArrayList<String> terms = Lists.newArrayList("apple", "linux", "php", "java", "python", "windows", "c++", "assembler", "android", "notatki", "książki", "piwo");


        double[][] studentMatrix = document.getStudentsMatrix(Path.of("Documents/students.txt"));
        double[][] distanceMatrixEuclides = euclidesDistanceMatrix(studentMatrix);
        double[][] distanceMatrixManhattan = manhattanDistanceMatrix(studentMatrix);
        double[][] distanceMatrixCzebyszew = czebyszewDistanceMatrix(studentMatrix);
        double[] test = MinValue.min_row(distanceMatrixCzebyszew);

        System.out.print("                     ");
        for (int j = 0; j < studentMatrix[0].length; j++) {

            System.out.print("  \t     " + terms.get(j));
        }
        for (int i = 0; i < studentMatrix.length; i++) {
            System.out.print("\nStudent " + (i + 1));
            for (int j = 0; j < studentMatrix[i].length; j++) {
                System.out.print("\t            " + (int) studentMatrix[i][j]);
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
                System.out.print("\t            " +String.format("%.2f", distanceMatrixEuclides[i][j]));
            }
        }
        System.out.println("\n");


        System.out.println("Manhattan:");
        for (int j = 0; j < distanceMatrixEuclides[0].length; j++) {

            System.out.print("\t              d" + (j));
        }
        for (int i = 0; i < distanceMatrixManhattan.length; i++) {
            System.out.print("\nd" + (i));
            for (int j = 0; j < distanceMatrixManhattan[i].length; j++) {
                System.out.print("\t            " + String.format("%.2f",distanceMatrixManhattan[i][j]));
            }
        }
        System.out.println();

        System.out.println("Czebyszew:");
        for (int j = 0; j < distanceMatrixEuclides[0].length; j++) {

            System.out.print("\t              d" + (j));
        }
        for (int i = 0; i < distanceMatrixCzebyszew.length; i++) {
            System.out.print("\nd" + (i));
            for (int j = 0; j < distanceMatrixCzebyszew[i].length; j++) {
                System.out.print("\t            " + String.format("%.2f",distanceMatrixCzebyszew[i][j]));
            }
        }
        System.out.println("\n");


        for (int i = 0; i < test.length; i++) {
            System.out.print("\t            " + String.format("%.2f",test[i]));

        }

    }



    }

