/*
Problem Link: https://leetcode.com/problems/word-break/
Problem Type: Recursive backtracking with Memoization/Dynamic Programming

!!!Note: The current code has a runtime of 11ms and is faster than only 14.98% of java submissions
          I'll update the code once I've optimized it
*/

class Solution {
    private int[] memo;

    private boolean backtrack(String s, List<String> words, int start) {
        if (start == s.length()) return true;
        if (memo[start] == 1) return true;
        if (memo[start] == -1) return false;
        String cur = "";
        for (int i = start; i < s.length(); i++) {
            cur += s.charAt(i);
            if (words.contains(cur)) {
                if (backtrack(s, words, i + 1)) {
                    memo[i + 1] = 1;
                    return true;
                }
                memo[i + 1] = -1;
            }
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length() + 1];
        return backtrack(s, wordDict, 0);
    }
}
