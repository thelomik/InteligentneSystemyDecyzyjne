package pl.decyzje;

public class MinValue {
    public static double [] min_row(double[][] n){

        double [] result = new double[n.length];


        for(int i=0;i<n.length;i++){
            double min = Double.MAX_VALUE;  //initial min with MAX int value
            for(int j=0;j<n[i].length;j++){

                if(min > n[i][j]&& n[i][j] > 0)    // if element smaller than min
                {
                    min= n[i][j];    //assign a new min value
                }

            }
            result[i]= min;          //save the min for the row

        }

        return result;
    }
}
