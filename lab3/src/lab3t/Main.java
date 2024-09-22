package lab3t;

import java.util.Scanner;
import java.io.File;

public class Main {

    public static double[][] getMatrix(Scanner scanner) throws Exception {
        int size = scanner.nextInt();
        double[][] matrix = new double[size-1][size];
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        if (scanner.hasNext()) {
            throw new InvalidArgumentsException("fhmc");
        }
        return matrix;
    }

    public static void main(String[] args) throws Exception {
//        if (args.length != 1) {
//            throw new InvalidArgumentsException(" 1 arg");
//        }
        String arg = "C:\\Users\\ded\\IdeaProjects\\lab3\\src\\lab3t\\Input.txt";
        Scanner scanner = new Scanner(new File(arg));
        double[][] matrix = getMatrix(scanner);

        for (int k = 0; k < matrix.length-1; k++) {
            for(int i = k+1; i< matrix.length; i++ ) {
                double tmp = -matrix[i][k]/matrix[k][k];
                for (int j = 0; j<matrix[0].length; j++) {
                    matrix[i][j]+=tmp*matrix[k][j];
                }
            }
        } //прямой ход Гаусса

        for (int k = matrix.length - 1; k>=0; k--) {
            for (int i = k-1; i >= 0; i-- ) {
                double tmp = -matrix[i][k]/matrix[k][k];
                for (int j = 0; j<matrix[0].length; j++) {
                    matrix[i][j]+=tmp*matrix[k][j];
                }

            }
        }
        int j=0;
        double x;
        System.out.println("Answers");
        for (int i = 0; i < matrix.length; i++) {
            x = matrix[i][matrix[0].length-1]/matrix[i][i];
            System.out.println(x);
        }
        System.out.println("Final Matrix");
        for (int i = 0; i < matrix.length; i++) {
            for (int t = 0; t < matrix[0].length; t++) {
                System.out.print(matrix[i][t] + " ");
            }
            System.out.println();
        }

    }
}