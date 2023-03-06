import java.util.*;


public class arrays {

    //pairs in array
    public static void pairs(int num[]) {
        for(int i=0; i<num.length; i++) {
            int curr= num[i]; //2,4,6,8,10
            for(int j=i+1; j<num.length; j++) {
                System.out.print("("+curr+","+num[j]+")");
            }
            System.out.println();
        }
    }
    //reverse an array
    public static void reverse(int num[]) {
        int first=0, last= num.length-1;
        while(first<last) {
            int temp= num[last];
            num[last]= num[first];
            num[first]= temp;
            first++;
            last--;
        }
        for(int i=0; i<num.length; i++) {
            System.out.print(num[i]+" ");
        }
        System.out.println();
    }
    //subarrays
    public static void subArr(int num[]) {
        int ts=0;
        for(int i=0; i<num.length; i++) {
            int start=i;
            for(int j=i; j<num.length; j++) {
                int end=j;
                for(int k=start; k<=end; k++) {
                    System.out.println(num[k]+ " ");
                }
                ts++;
                System.out.println();
            }
    
        }
        System.out.println("Total subarrays: "+ ts);
    }
    //BRUTE FORCE METHOD
    public static void maxSub(int num[]) {
        int currSum=0;
        int maxSum= Integer.MIN_VALUE;
        for(int i=0; i<num.length; i++) {
            int start= i;
            for(int j=i; j<num.length; j++) {
                int end=j;
                currSum=0;
                for(int k=start; k<=end; k++) {
                    currSum+=num[k];
                }
                System.out.println(currSum);
                if(maxSum<currSum) {
                    maxSum= currSum;
                }
            }
        }
        System.out.println("Max Sum: "+ maxSum);
    }
    //PREFIX SUM
    public static void preSum(int num[]) {
        int currSum=0;
        int maxSum= Integer.MIN_VALUE;
        int prefix[]= new int[num.length];  //new array
        prefix[0]= num[0];
        
        for(int i=1; i<prefix.length; i++) {
            prefix[i]= prefix[i-1]+ num[i];
        }
        for(int i=0; i<num.length; i++) {
            int start=i;
            for(int j=i; j<num.length; j++) {
                int end=j;
                currSum=start==0 ? prefix[end] : prefix[end]-prefix[start-1];
                if(maxSum<currSum) {
                    maxSum= currSum;
                }
            }
        }
        System.out.println("Max Sum: "+ maxSum);
    }
    //KADANE'S ALGO
    public static void kadanes(int num[]) {
        int maxSum= Integer.MIN_VALUE;
        int currSum= 0;
        for(int i=0; i<num.length; i++) {
            currSum= currSum+num[i];
            if(currSum<0) {
                currSum=0;
            }
            maxSum= Math.max(currSum, maxSum);
        }
        System.out.println("Max Sum: "+maxSum);
    }

    
    public static void main(String[] args) {
        int num[]= {2,4,6,8,10,};
        //pairs(num);
        //reverse(num);
        //subArr(num);
        //maxSub(num);
        //preSum(num);
        //kadanes(num);
    
    }
}
