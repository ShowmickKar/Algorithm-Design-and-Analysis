/* Problem Link: https://leetcode.com/problems/sort-colors/ */

class Solution {
    public void sortColors(int[] nums) {
        if (nums.length < 2) return;
        int start = 0, end = nums.length - 1, ptr = 0;
        while (ptr <= end && start < end) {
            if (nums[ptr] == 0) {
                nums[ptr] = nums[start];
                nums[start] = 0;
                start++;
                ptr++;
            } else if (nums[ptr] == 2) {
                nums[ptr] = nums[end];
                nums[end] = 2;
                end--;
            } else ptr++;
        }
    }
}
