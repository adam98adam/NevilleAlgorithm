public class Neville {

    public static double[] xs = {-1.0,0.0,1.0,2.0,3.0};
    public static double[] ys = {-4.0,-1.0,2.0,11.0,8.0};
    public static double[][] matrix;

    public static void creatematrix(int n){
        matrix = new double[n][n];
        for(int i=0;i<n;i++){
            matrix[i][0] = ys[i];
        }
    }

    public static void algorithm(int n,double x){
        for(int j=1;j<n;j++)
            for(int i=0;i<n-j;i++) {
                matrix[i][j] = ((x - xs[i]) * matrix[i + 1][j - 1] - (x - xs[i + j]) * matrix[i][j - 1]) / (xs[i + j] - xs[i]);
                System.out.println("i = " + i + " , j = " + j);
            }
    }




    public static void main(String[] args) {
        creatematrix(xs.length);
        algorithm(xs.length,10.0);
        for(int i=0;i<xs.length;i++)
            for(int j=0;j<xs.length;j++)
            System.out.println("Matrix[" + i +"][" + j + "] : " + matrix[i][j]);

    }


}
