/* Problem Link: https://leetcode.com/problems/contains-duplicate/  */

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Boolean> duplicate = new HashMap<Integer, Boolean>();
        for (int i = 0; i < nums.length; i++) {
            if (duplicate.get(nums[i]) != null) return true;
            duplicate.put(nums[i], true);
        }
        return false;
    }
}
