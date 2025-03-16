package Assignment_3;
import java.util.*;
/*Design a Java program to perform matrix operations such as addition, multiplication, 
and transpose. Introduce scenarios where accessing elements beyond the matrix bounds 
results in an ArrayIndexOutOfBoundsException. Handle these exceptions effectively and 
provide meaningful error messages that clearly indicate the nature of the exception.*/

public class Q7 {

    public static int[][] addMatrices(int[][] mat1, int[][] mat2) {
        int rows=mat1.length;
        int cols=mat1[0].length;
        int[][] res=new int[rows][cols];
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                res[i][j]=mat1[i][j]+mat2[i][j];
            }
        }
        return res;
    }

    public static int[][] multiplyMatrices(int[][] mat1, int[][] mat2) {
        int rows=mat1.length;
        int cols=mat2[0].length;
        int[][] res=new int[rows][cols];
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                res[i][j]=0;
                for (int k=0;k<mat1[0].length;k++) {
                    res[i][j]+=mat1[i][k]*mat2[k][j];
                }
            }
        }
        return res;
    }

    public static int[][]transposeMatrix(int[][] matrix) {
        int rows=matrix.length;
        int cols = matrix[0].length;
        int[][] res=new int[cols][rows];
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                res[j][i]=matrix[i][j];
            }
        }
        return res;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row:matrix) {
            for (int i:row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] mat1 = { {1, 2, 3},{4, 5, 6},{7, 8, 9}};
        int[][] mat2 = {{9, 8, 7},{6, 5, 4},{3, 2, 1}};

        try {
            int addRes[][] = addMatrices(mat1, mat2);
            System.out.println("Addition:");
            printMatrix(addRes);

           
            int multRes[][]= multiplyMatrices(mat1, mat2);
            System.out.println("Multiplication:");
            printMatrix(multRes);

            int[][] transRes = transposeMatrix(mat1);
            System.out.println("Transpose of the first matrix:");
            printMatrix(transRes);

            System.out.println(mat1[4][4]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    
}

/*
OUTPUT :
Addition:
10 10 10 
10 10 10
10 10 10
Multiplication:
30 24 18
84 69 54
138 114 90
Transpose of the first matrix:
1 4 7
2 5 8
3 6 9
java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 3
 */
