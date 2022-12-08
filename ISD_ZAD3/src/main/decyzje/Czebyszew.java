package pl.decyzje;

public class Czebyszew {

    public  static double[][] czebyszewDistanceMatrix(double[][] data) {
        int n = data.length;
        double[][] distanceMatrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distanceMatrix[i][j] = czebyszewDistance(data[i], data[j]);
            }
        }
        return distanceMatrix;
    }

    public static double czebyszewDistance(double[] x, double[] y) {
        double maxDistance = 0;
        for (int i = 0; i < x.length; i++) {
            maxDistance = Math.max(maxDistance, Math.abs(x[i] - y[i]));
        }
        return maxDistance;
    }
}
