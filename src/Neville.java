import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;
public class Neville {

    public static double[] xs;
    public static double[] ys;
    public static double[][] matrix;


    public static boolean ifInteger(String x){
        try {
            Integer.parseInt(x);
            return true;
        }catch(Exception e) {
            return false;
        }
    }


    public static boolean ifDouble(String x) {
        try {
            Double.parseDouble(x.replace(',','.'));
            return true;
        }catch(Exception e) {
            return false;
        }
    }



    public static void createarrays() {
        String s;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a size of an array that you would like to create(minimum size is 4, maximum is 10):");
        s = in.nextLine();
        while((!ifInteger(s)) || (Integer.parseInt(s) < 4) || (Integer.parseInt(s) > 10)) {
            System.out.println("Entered value '" + s + "' is incorrect.Please try again, remember minimum size is 4, maximum is 10:");
            s = in.nextLine();
        }
        xs = new double[Integer.parseInt(s)];
        ys = new double[Integer.parseInt(s)];

    }

    public static String printelemets(double[] array,int x) {
        String s = "";
        for(int i=0;i<x;i++)
            s += array[i] + " ";
        return s;
    }




    public static void fillarrays() {
        String s;
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < xs.length; i++) {
            System.out.print("x" + i + " = ");
            s = in.nextLine();
            if(i > 0) {
                while(check(xs, i, s)) {
                    System.out.println("Enter a number other than " + printelemets(xs,i));
                    System.out.print("x" + i + " = ");
                    s = in.nextLine();
                }
            }
            if(i == 0) {
                while(!ifDouble(s)) {
                    System.out.println("Entered value '" + s + "' is incorrect. Try again");
                    s =in.nextLine();
                }
            }
            xs[i] = Double.parseDouble(s.replace(',','.'));
            System.out.print("y" + i + " = ");
            s = in.nextLine();
            while(!ifDouble(s)) {
                System.out.println("Entered value '" + s + "' is incorrect. Try again");
                s =in.nextLine();
            }
            ys[i] = Double.parseDouble(s.replace(',','.'));
        }
    }

    public static void creatematrix(int n) {
        matrix = new double[n][n];
        for(int i=0;i<n;i++){
            matrix[i][0] = ys[i];
        }
    }



    public static boolean check(double[] array,int size,String x) {
        double parsedInput;
        if(ifDouble(x)) {
            parsedInput = Double.parseDouble(x.replace(',','.'));
        }else {
            return true;
        }

       for(int a=0;a<size;a++) {
           if(array[a] == parsedInput)
               return  true;

       }
       return false;
    }

    public static double inputx() {
        String x = Double.toString(xs[0]);
        boolean isAnyInputEntered = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number other than " + Arrays.toString(xs));
        while(check(xs,xs.length,x)) {
            if(isAnyInputEntered)
                System.out.println("Entered value '"+x+"' is incorrect. Try again");
            x = input.next();
            isAnyInputEntered = true;
        }
        return Double.parseDouble(x.replace(',','.'));
    }

    public static void checkpij(double x,int n) {
        String s;
        Scanner input = new Scanner(System.in);
        System.out.println("Do u want to check the value of Pi,j("+x+") ?" + "\nType 'yes' or 'no':");
        s = input.nextLine();
        while(!(s.equals("yes")||s.equals("no"))) {
           System.out.println("Sorry,You can just type 'yes' or 'no'\nTry again:");
           s = input.nextLine();
        }
        if(s.equals("yes")) {
            for(int j=0;j<n;j++)
                for(int i=0;i<n-j;i++) {
                    System.out.println("P"+i+","+j+"("+x+") = "+matrix[i][j]);
                }

        }

    }

    public static void algorithm(int n) {
        double x = inputx();
        for(int j=1;j<n;j++)
            for(int i=0;i<n-j;i++) {
                matrix[i][j] = ((x - xs[i]) * matrix[i + 1][j - 1] - (x - xs[i + j]) * matrix[i][j - 1]) / (xs[i + j] - xs[i]);
            }
        System.out.println("f(" + x + ") = " + matrix[0][n-1]);
        checkpij(x,n);
    }

    public static void main(String[] args) {
        createarrays();
        fillarrays();
        creatematrix(xs.length);
        algorithm(xs.length);
    }
}
