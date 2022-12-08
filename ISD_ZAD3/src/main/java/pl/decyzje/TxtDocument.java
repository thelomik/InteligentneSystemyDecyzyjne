package pl.decyzje;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class TxtDocument {


    int rows = 3;
    int columns = 12;

    public double[][] getMatrix(Path txtPath) {
        double [][] myArray;
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(txtPath.toAbsolutePath().toString())));

            myArray = new double[rows][columns];
            while (sc.hasNextLine()) {
                for (int i = 0; i < myArray.length; i++) {
                    String[] line = sc.nextLine().trim().split(" ");
                    for (int j = 0; j < line.length; j++) {
                        myArray[i][j] = Double.parseDouble(line[j]);
                    }
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(new RuntimeException(String.format("Could not read text: %s", txtPath), e));
        }
        return myArray;
    }
}

