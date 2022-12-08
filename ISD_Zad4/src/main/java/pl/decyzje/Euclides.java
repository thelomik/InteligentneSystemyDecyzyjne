package pl.decyzje;

public class Euclides {
    public static double[][] euclidesDistanceMatrix(double[][] data) {
        int n = data.length;
        double[][] distanceMatrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distanceMatrix[i][j] = euclidesDistance(data[i], data[j]);
            }
        }
        return distanceMatrix;
    }

    public static double euclidesDistance(double[] x, double[] y) {
        double distance = 0;
        for (int i = 0; i < x.length; i++) {
            distance += Math.pow(x[i] - y[i], 2);
        }
        return Math.sqrt(distance);
    }
}
