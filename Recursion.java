import java.util.*;
public class Recursion {
    
    public static void printDec(int n) {
        if(n==1) {
            System.out.println(n);
            return;
        }
        System.out.print(n+" ");
        printDec(n-1);
    }
    
    public static void printInc(int n) {
        if(n==1) {
            System.out.println(n);
            return;
        }
        printInc(n-1);
        System.out.print(n+ " ");
    }

    public static int fact(int n) {
        if(n==0) {
            return 1;
        }
        return n* fact(n-1);
    }

    public static int sum(int n) {
        if(n==1) {
            return 1;
        }
        return n + sum(n-1);
    }

    public static int fibonacci(int n) {
        //base case
        if(n==0 || n==1) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static boolean isSorted(int arr[], int i) {
        if(i==arr.length-1) {
            return true;
        }
        if(arr[i]>arr[i+1]) {
            return false;
        }
        return isSorted(arr, i+1);
    }

    public static int firstOcc(int arr[], int key, int i) {
        //base case
        if(i==arr.length) {
            return -1;
        }
        if(key==arr[i]) {
            return i;
        }
        return firstOcc(arr, key, i+1);
    }

    public static int lastOcc(int arr[], int key, int i) {
        if(i==arr.length) {
            return -1;
        }
        int isFound= lastOcc(arr, key, i+1);
        if(isFound== -1 && arr[i]==key) { //-1 when no valid index, i.e. not found
            return i;
        }
        return isFound;
    }

    public static int power(int x, int n) {
        if(n==0) {
            return 1;
        }
        //return x*power(x, n-1);
        int halfPow = power(x, n/2);
        int halfSq = halfPow * halfPow;
        //if n is odd
        if(n%2 !=0) {
            halfSq= x* halfSq;
        }
        return halfSq;
    }

    public static int tiling(int n) { //2 X n
        //base case
        if(n==0 || n==1) {
            return 1;
        }
        //vertical
        int fnm1 = tiling(n-1);
        //horizontal
        int fnm2= tiling(n-2);
        int totWays= fnm1+fnm2;
        return totWays;
    }

    public static void dupString(String str, int idx, StringBuilder newStr, boolean map[]) {
        //base case
        if(idx==str.length()) {
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(idx);
        if(map[currChar-'a']==true) {
            //duplicate
            dupString(str, idx+1, newStr, map);
        } else {
            map[currChar-'a']= true;
            dupString(str, idx+1, newStr.append(currChar), map);
        }
    }

    public static int friendPair(int n) {
        if(n==1 || n==2) {
            return n;
        }
        return friendPair(n-1) + (n-1) * friendPair(n-2);
    }

    public static void binaryString(int n, int lastplace, String str) {
        //base case
        if(n==0) {
            System.out.println(str);
            return;
        }
        binaryString(n-1, 0, str+"0");
        if(lastplace==0) {
            binaryString(n-1, 1, str+ "1");
        }
    }

    public static void occur(int arr[], int key, int i) {
        if(i==arr.length) {
            return;
        }
        if(arr[i]==key) {
            System.out.print(i+ " ");
        }
        occur(arr, key, i+1);
    }

    public static void main(String[] args) {
        //int n=5;
        //printDec(n);
        //printInc(n);
        //System.out.println(fact(n));
        //System.out.println(sum(n));
        //System.out.println(fibonacci(n));
        // int arr[]= {1, 2, 3, 4, 5};
        // System.out.println(isSorted(arr, 0));
        // int arr[] = {8,3,6,9,5,10,2,5,3};
        // int key=5;
        //System.out.println(firstOcc(arr, key, 0));
        //System.out.println(lastOcc(arr, key, 0));
        //System.out.println(power(2, 5));
        //System.out.println(tiling(4));
        // String str= "rohiinni";
        // dupString(str, 0, new StringBuilder(""), new boolean[26]); 
        //System.out.println(friendPair(4));
        //binaryString(3, 0, "");
        int arr[]= {3, 2, 4, 5, 6, 2, 7, 2, 2};
        int key=2;
        occur(arr, key, 0);
        System.out.println();
    }
}
