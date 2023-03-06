import java.util.*;
public class patterns {

    public static void hollowrect(int rows, int cols) {
        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=cols; j++) {
                if(i==1||i==rows||j==1||j==cols) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void halfpy(int n) {
        for(int i=1; i<=n; i++) {
            //spaces
            for(int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pyrNum(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n-i+1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void floyds(int n) {
        int c=1;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print(c+ " ");
                c++;
            }
            System.out.println();
        }
    }
    public static void zero_one(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                if((i+j)%2==0) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    public static void butterfly(int n) {

        //1st half
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            for(int j=1; j<=2*(n-i); j++) {
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //2nd half
        for(int i=n; i>=1; i--) {
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            for(int j=1; j<=(n-i)*2; j++) {
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        //hollowrect(6,8);
        //halfpy(4);
        //pyrNum(5);
        //floyds(5);
        //zero_one(5);
        butterfly(4);
    }
}
