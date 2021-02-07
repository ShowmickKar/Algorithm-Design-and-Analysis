/* Problem Link: https://leetcode.com/problems/product-of-array-except-self/ */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] product_from_left = new int[nums.length];
        int[] product_from_right = new int[nums.length];
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                product_from_left[i] = nums[i];
            } else {
                product_from_left[i] = product_from_left[i - 1] * nums[i];
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1)
                product_from_right[i] = nums[i];
            else
                product_from_right[i] = product_from_right[i + 1] * nums[i];
            try {
                ans[i] = product_from_right[i + 1] * product_from_left[i - 1];
            } catch (Exception e) {
                try {
                    ans[i] = product_from_right[i + 1];
                } catch (Exception f) {
                    ans[i] = product_from_left[i - 1];
                }
            }
        }
        return ans;
    }
}
