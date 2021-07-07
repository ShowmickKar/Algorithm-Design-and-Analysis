/*
Problem Link: https://leetcode.com/problems/coin-change/
Problem Type: DP, Recursion, caching  
*/

class Solution {
    private int calculate(int[] coins, int amount, int[] cache) {
        if (amount < 0) return -1;
        if (cache[amount] > 0 || amount == 0) return cache[amount];
        cache[amount] = 10001;
        for (int c : coins) {
            if (c > amount) continue;
            int remaining = calculate(coins, amount - c, cache);
            if (remaining < 0) {
                continue;
            }
            else {
                cache[amount] = Math.min(1 + remaining, cache[amount]);
            }            
        }
        return (cache[amount] < 10001 ? cache[amount] : -1);
    }

    public int coinChange(int[] coins, int amount) {
        int[] cache = new int[amount + 1];
        return calculate(coins, amount, cache);
    }
}
