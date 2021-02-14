/* Problem Link: https://leetcode.com/problems/missing-number/ */

// Approach 1: Using intuition and negative indexing

class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                ans = i + 1;
                continue;
            }
            nums[Math.abs(nums[i]) - 1] *= -1;                
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans = i + 1;
                break;
            }
        }
        return ans;
    }
}

// Approach 2: Using Formula for sum(Faster than 100% submissions)

class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0, n = nums.length;
        for (int i : nums) {
            sum += i;
        }
        return (n * (n + 1))/2 - sum;
    }
}
