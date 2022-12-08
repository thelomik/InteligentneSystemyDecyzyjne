package pl.decyzje;


import java.io.*;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class TxtDocument {


    int rows = 10;
    int columns = 12;

    public double[][] getStudentsMatrix(Path txtPath) {
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

