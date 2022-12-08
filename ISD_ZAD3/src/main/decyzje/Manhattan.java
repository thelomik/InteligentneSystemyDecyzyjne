package pl.decyzje;

public class Manhattan {

    public static double[][] manhattanDistanceMatrix(double[][] data) {
        int n = data.length;
        double[][] distanceMatrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distanceMatrix[i][j] = manhattanDistance(data[i], data[j]);
            }
        }
        return distanceMatrix;
    }

    public static double manhattanDistance(double[] x, double[] y) {
        double distance = 0;
        for (int i = 0; i < x.length; i++) {
            distance += Math.abs(x[i] - y[i]);
        }
        return distance;
    }
}
