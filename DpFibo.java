import java.util.Arrays;

public class DpFibo {

    //recursion approach
    public static int countWays(int n) {
        if(n==0) {
            return 1;
        }
        if(n<0) {
            return 0;
        }
        return countWays(n-1) + countWays(n-2);
    }

    //memoization approach
    public static int countMemo(int n, int ways[]) {
        if(n==0) {
            return 1;
        }
        if(n<0) {
            return 0;
        }
        if(ways[n] != -1) { //already calculated
            return ways[n];
        }
        ways[n] = countMemo(n-1, ways) + countMemo(n-2, ways);
        return ways[n];
    }

    //tabulation approach
    public static int countTable(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;

        for(int i=1; i<=n; i++) {
            if(i==1) {
                dp[i] = dp[i-1] + 0; //otherwise -1 will come 
            } else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n=5;
        //System.out.println(countWays(n));
        int ways[] = new int[n+1];
        Arrays.fill(ways, -1);
        //System.out.println(countMemo(n, ways));
        System.out.println(countTable(n));
    }
}
