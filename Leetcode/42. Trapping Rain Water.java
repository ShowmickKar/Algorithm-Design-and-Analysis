/* Problem link: https://leetcode.com/problems/trapping-rain-water/ */

// Approach 1: Dynamic Programming Time Complexity O(n), Space Complexity O(n)

class Solution {
    public int trap(int[] height) {
        int area = 0;
        int[] left = height.clone();
        int[] right = height.clone();
        for (int i = 1; i < height.length; i++) left[i] = Math.max(height[i], left[i - 1]);
        for (int i = height.length - 2; i >= 0; i--) right[i] = Math.max(height[i], right[i + 1]);
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(left[i], right[i]);
            if (height[i] < min) {
                area += min - height[i];
            }
        }
        return area;
    }
}

// Approach 2: Two Pointers: Time Complexity o(n), Space Complexity O(1)

class Solution {
    public int trap(int[] height) {
        int left_max = 0, right_max = 0;
        int left = 0, right = height.length - 1;
        int ans = 0;
        while (left < right) {
            left_max = Math.max(left_max, height[left]);
            right_max = Math.max(right_max, height[right]);
            if (left_max < right_max) {
                ans += Math.max(0, left_max - height[left]);
                left++;
            } else {
                ans += Math.max(0, right_max - height[right]);
                right--;
            }
        }
        return ans;
    }
}
