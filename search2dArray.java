import java.util.*;
public class search2dArray {
    
    public static boolean staircase_search(int  matrix[][], int key) {
        int col=0, row= matrix.length-1; //n-1 to 0
        while(col<matrix[0].length && row>=0) {
            if(matrix[row][col]==key) {
                System.out.println("Key found at ("+ row+ ","+ col+")");
                return true;
            } 
            else if(key<matrix[row][col]) {
                row--;
            }
            else {
                col++;
            }
        }
        System.out.println("Key not found");
        return false;
    }

    public static void count(int matrix[][]) {
        int c=0;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j]==7) {
                    c++;
                }
            }
        }
        System.out.println("Number of times 7 comes: "+c);
    }

    public static void sum(int matrix[][]) {
        int s=0;
        for(int i=1; i<matrix.length-1; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                s+=matrix[i][j];
            }
        }
        System.out.println("Sum of second row is: "+ s);
    }

    public static void transpose(int matrix[][]) {
        int row=2, col=3;
        //printing the original matrix
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }

        //transpose
        int trans[][]= new int [col][row];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                trans[j][i]= matrix[i][j];
            }
        }
        //printing transpose
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.err.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        /*int matrix[][] = {{10,20,30,40},
                          {15,25,35,45},
                          {27,29,37,48},
                          {32,33,39,50}};
        int key=35;
        staircase_search(matrix, key);*/

        /*int matrix[][]= {{4,7,8},
                         {8,8,7}};
        count(matrix);*/

        /*int matrix[][] = {{1,4,9}, {11,4,3}, {2,2,3}};
        sum(matrix);*/

        int matrix[][]= {{2,3,7},{5,6,7}};
        transpose(matrix);
    }

}

