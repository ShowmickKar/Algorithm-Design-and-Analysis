/* https://leetcode.com/problems/container-with-most-water/ */

class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, ans = 0;
        while(i < j) {
            ans = Math.max(ans, Math.min(height[i], height[j]) * (j - i));
            if (height[i] <= height[j]) i++;
            else j--;
        }
        return ans;
    }
}
