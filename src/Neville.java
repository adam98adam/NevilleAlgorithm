import java.util.Scanner;
import java.util.Arrays;
public class Neville {

    public static double[] xs = {-1.0,0.0,1.0,2.0,3.0};
    public static double[] ys = {-4.0,-1.0,2.0,11.0,8.0};
    public static double[][] matrix;

    public static void creatematrix(int n) {
        matrix = new double[n][n];
        for(int i=0;i<n;i++){
            matrix[i][0] = ys[i];
        }
    }

    public static boolean check(double[] array,double x) {
        for(int a=0;a<array.length;a++) {
            if (array[a] == x)
                return true;
        }
        return false;
    }

    public static double inputx() {
        double x = xs[0];
        Scanner input = new Scanner(System.in);
        while(check(xs,x)) {
            System.out.println("Enter a double value other than " + Arrays.toString(xs) + " values");
            x = input.nextDouble();
        }
        return x;
    }

    public static void algorithm(int n) {
        double x = inputx();
        for(int j=1;j<n;j++)
            for(int i=0;i<n-j;i++) {
                matrix[i][j] = ((x - xs[i]) * matrix[i + 1][j - 1] - (x - xs[i + j]) * matrix[i][j - 1]) / (xs[i + j] - xs[i]);
            }
        System.out.println("f(" + x + ") = " + matrix[0][n-1]);
    }

    public static void main(String[] args) {
        creatematrix(xs.length);
        algorithm(xs.length);
    }
}
