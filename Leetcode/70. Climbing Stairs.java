/* Problem Link: https://leetcode.com/problems/climbing-stairs/ */

// Iterative

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

// Recursive

class Solution {
    private int dfs(int n, int[] memo) {
        if (n < 0) return 0;
        if (n < 3) {
            memo[n] = n;
            return memo[n];
        }
        if (memo[n] < 1) {
            memo[n] = dfs(n - 1, memo) + dfs(n - 2, memo);
        }
        return memo[n];
    }

    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return dfs(n, memo);
    }
}
