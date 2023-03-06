import java.util.*;
public class DpKnapsack {
    public static int knapsackTable(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i=0; i<dp.length; i++) {
            dp[i][0] = 0;
        }
        for(int j=0; j<dp[0].length; j++) {
            dp[0][j] = 0;
        }
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<W+1; j++) {
                int v = val[i-1];
                int w = wt[i-1];

                if(w <= j) {
                    int incProfit = v + dp[i-1][j-w];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        return dp[n][W];
    }

    public static int unboundedKnapsack(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n+1][W+1];

        for(int i=0; i<n+1; i++) {
            dp[i][0] = 0;
        }
        for(int j=0; j<W+1; j++) {
            dp[0][j] = 0;
        }
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<W+1; j++) {
                if(wt[i-1] <= j) { //valid
                    dp[i][j] = Math.max(val[i-1] + dp[i][j-wt[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }

    //target sum
    public static boolean targetSumSubset(int arr[], int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];

        for(int i=0; i<n+1; i++) {
            dp[i][0] = true;
        }
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<sum+1; j++) {
                int v = arr[i-1];
                if(v <= j && dp[i-1][j-v] == true) {
                    dp[i][j] = true;
                }
                else if(dp[i-1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][sum];
    }


    public static void main(String[] args) {
        // int val[] = {15, 14, 10, 45, 30};
        // int wt[] = {2, 5, 1, 3, 4};
        // int W = 7;
        //for 0-1 knapsack
        // int dp[][] = new int[val.length+1][W+1];
        // for(int i=0; i<dp.length; i++) {
        //     for(int j=0; j<dp[0].length; j++) {
        //         dp[i][j] = -1;
        //     }
        // }
        // System.out.println(knapsackTable(val, wt, W));
        // System.out.println(unboundedKnapsack(val, wt, W));
        int arr[] = {4, 2, 7, 1, 3};
        int sum = 10;

        System.out.println(targetSumSubset(arr, sum));
    }
}
