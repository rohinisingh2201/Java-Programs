import java.util.*;
public class rainwater {
    public static int trapping(int ht[]) {
        int n= ht.length;
        
        //cal max left boundary
        int leftMax[]= new int[n];
        leftMax[0]= ht[0];
        for(int i=1; i<n; i++) {
            leftMax[i]= Math.max(ht[i], leftMax[i-1]);
        }
        
        //cal max right boundary
        int rightMax[]= new int[n];
        rightMax[n-1]= ht[n-1];
        for(int i=n-2; i>=0; i--) {
            rightMax[i]= Math.max(ht[i], rightMax[i+1]);
        }

        int trap=0;
        for(int i=0; i<n; i++) {
            int waterL= Math.min(leftMax[i], rightMax[i]);
            trap+= waterL - ht[i]; //trapped water= water level - ht
        }
        return trap;
    }
    public static void main(String[] args) {
        int ht[]={4, 2, 0, 6, 3, 2, 5};
        System.out.println(trapping(ht));
    }
}
