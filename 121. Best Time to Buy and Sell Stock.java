/* https://leetcode.com/problems/best-time-to-buy-and-sell-stock/ */

class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int[][] dp = new int[prices.length][2];
        for (int i = prices.length - 1; i >= 0; i--) {
            if (i == prices.length - 1)
                dp[i][0] = prices[i];
            else
                dp[i][0] = Math.max(dp[i + 1][0], prices[i]);
        }
        for (int i = 0; i < prices.length; i++) {
            if (i == 0)
                dp[i][1] = prices[i];
            else
                dp[i][1] = Math.min(dp[i - 1][1], prices[i]);
            ans = Math.max(dp[i][0] - dp[i][1], ans);
        }
        return ans;
    }
}
