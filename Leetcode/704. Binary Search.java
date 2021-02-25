/* Problem Link: https://leetcode.com/problems/binary-search/ */

class Solution {
    public int binarySearch(int[] nums, int i, int j, int target) {
        int middle = (i + j)/2;
        if (nums[middle] == target) return middle;
        if (i >= j) return -1;
        if (target < nums[middle]) return binarySearch(nums, i, middle, target);
        if (target > nums[middle]) return binarySearch(nums, middle + 1, j, target);
        return -1;
    }
    
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);    
    }
}
