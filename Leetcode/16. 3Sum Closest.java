/* Problem Link: https://leetcode.com/problems/3sum-closest/ */

/* Approach: Two Pointers and Sorting
  Time Complexity: We have outer and inner loop, each going through n elements, Sorting th array takes O(nlogn) time. So overall complexity is O(nlogn + n^2). This is asymptotically equivalent to O(n^2)
  Space Complexity: From O(logn) to O(n) depending on the implementation of our sorting algorithm
  */

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int difference = 3001, ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (Math.abs(target - (nums[i] + nums[left] + nums[right])) < difference) {
                    difference = Math.abs(target - (nums[i] + nums[left] + nums[right]));
                    ans = nums[i] + nums[left] + nums[right];
                }
                if (nums[i] + nums[left] + nums[right] > target) right--;
                else left++;
            }
        }
        return ans;
    }
}
