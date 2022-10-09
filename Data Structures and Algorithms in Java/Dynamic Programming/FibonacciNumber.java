import java.util.*;

public class FibonacciNumber {

    public static void main(String[] args) {
        int n = 10;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(fibonacciRecursion(n));
        System.out.println(fibonacciMemoization(n, dp));
        System.out.println(fibonacciTabulation(n, dp));
        System.out.println(fibonacciSpaceOptimizedAfterTabulation(n));
    }

    private static int fibonacciRecursion(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    private static int fibonacciMemoization(int n, int[] dp) {
        if (n <= 1)
            return n;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = fibonacciMemoization(n - 1, dp) + fibonacciMemoization(n - 2, dp);
    }

    private static int fibonacciTabulation(int n, int[] dp) {
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private static int fibonacciSpaceOptimizedAfterTabulation(int n) {
        int prev1 = 0, prev2 = 1, sum = 0;
        if (n <= 1)
            return n;
        for (int i = 2; i <= n; i++) {
            sum = prev1 + prev2;
            prev1 = prev2;
            prev2 = sum;
        }
        return sum;
    }
}