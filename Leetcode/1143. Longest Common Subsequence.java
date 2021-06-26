// Problem Link: https://leetcode.com/problems/longest-common-subsequence/

class Solution {
    public int[][] dp;
    public int calculate(String s1, String s2, int i, int j) {
        if (i == s1.length() || j == s2.length()) return 0;

        if (s1.charAt(i) == s2.charAt(j)) {
            if (dp[i][j] < 0) {
                dp[i][j] = 1 + calculate(s1, s2, i + 1, j + 1);
            }  
            return dp[i][j];          
        } else {
            if (dp[i][j] < 0) {
                dp[i][j] = Math.max(calculate(s1, s2, i + 1, j), calculate(s1, s2, i, j + 1));
            }
            return dp[i][j];        
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j]= -1;
            }
        }
        return calculate(text1, text2, 0, 0);
    }
}
