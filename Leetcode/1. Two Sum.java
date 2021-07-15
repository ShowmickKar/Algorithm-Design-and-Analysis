// Problem Link: https://leetcode.com/problems/two-sum/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (m.get(target - nums[i]) != null) {
                int ans[] = { m.get(target - nums[i]), i };
                return ans;
            }
            m.put(nums[i], i);
        }
        return result;
    }
}
