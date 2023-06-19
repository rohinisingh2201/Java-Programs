//Recursion way to solve
public class KnapSack {
    
    public static int knap(int val[], int w[], int W, int n, int dp[][]) {
        if(W == 0 || n == 0) {
            return 0;
        }
        if(dp[n][W] != -1) { //if the result is already stored in the 2D matrix
            return dp[n][W]; //then directly return that
        }
        
        if(w[n-1] <= W) { //valid

            //include that
            int one = val[n-1] + knap(val, w, W-w[n-1], n-1, dp);
            //exclude that
            int two = knap(val, w, W, n-1, dp);
            //store the max value in the dp array to use it afterwards
            dp[n][W] = Math.max(one, two);
            return dp[n][W];

        } else { //invalid
            dp[n][W] = knap(val, w, W, n-1, dp);
            return dp[n][W];
        }
    }

    public static int knapTab(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        //initialising
        for(int i=0; i<dp.length; i++) { //0th col
            dp[i][0] = 0;
        }
        for(int j=0; j<dp[0].length; j++) { //0th row
            dp[0][j] = 0;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<W+1; j++) {
                int v = val[i-1]; //val of ith item
                int w = wt[i-1]; //wt of ith item

                if(w <= j) {
                    int pro1 = v + dp[i-1][j-w];
                    int pro2 = dp[i-1][j];
                    dp[i][j] = Math.max(pro1, pro2);
                } else {
                    int pro2 = dp[i-1][j];
                    dp[i][j] = pro2;
                }

            }
        }
        print(dp);
        return dp[n][W];

    }

    public static void print(int dp[][]) {
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int val[] = {16, 7, 34, 8, 56};
        int w[] = {4, 2, 5, 1, 7};
        int W = 8;
        int dp[][] = new int[val.length+1][W+1];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                dp[i][j] = -1; //initializing with -1
            }
        }
        // System.out.println(knap(val, w, W, val.length, dp));
        System.out.println(knapTab(val, w, W));
    }
}


