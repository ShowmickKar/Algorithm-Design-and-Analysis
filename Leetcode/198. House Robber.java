/* Problem Link: https://leetcode.com/problems/house-robber/ */

class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0)
                dp[i + 1] = nums[i];
            else {
                dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
            }
        }
        return dp[nums.length];
    }
}
