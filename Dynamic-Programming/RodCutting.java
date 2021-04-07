public class RodCutting {
    public int rodCutting(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = prices[i - 1];
            for (int k = 1; k < i; k++) {
                dp[i] = Math.max(dp[i], dp[i - k] + dp[k]);
            }
        }
        return dp[n];
    }
}
