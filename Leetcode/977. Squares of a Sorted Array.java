/* Problem Link: https://leetcode.com/problems/squares-of-a-sorted-array/ */

class Solution {
    public int[] sortedSquares(int[] nums) {
        ArrayList<Integer> positive  = new ArrayList<Integer>();
        ArrayList<Integer> negative  = new ArrayList<Integer>();
        for (int i : nums) {
            if (i < 0) negative.add(Math.abs(i));
            else positive.add(i);
        }
        int[] ans = new int[nums.length];
        int p = 0, n = negative.size() - 1, ptr = 0;
        while (p < positive.size() && n >= 0) {
            if (positive.get(p) <= negative.get(n)) {
                ans[ptr] = positive.get(p) * positive.get(p);
                p++;
            } else {
                ans[ptr] = negative.get(n) * negative.get(n);
                n--;
            }
            ptr++;
        }
        while(p < positive.size()) {
            ans[ptr] = positive.get(p) * positive.get(p);
            p++;
            ptr++;
        }  
        while(n >= 0) {
            ans[ptr] = negative.get(n) * negative.get(n);
            n--;
            ptr++;
        }
        return ans;
    }
}
