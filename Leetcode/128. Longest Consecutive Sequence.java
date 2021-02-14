/* https://leetcode.com/problems/longest-consecutive-sequence/ */

class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        if (nums.length == 0)
            return ans;
        HashMap<Integer, Boolean> consequtive = new HashMap<Integer, Boolean>();
        for (int i = 0; i < nums.length; i++) {
            consequtive.put(nums[i], false);
        }
        for (int num : nums) {
            if (consequtive.get(num) == true)
                continue;
            consequtive.put(num, true);
            int current = num, current_length = 1;
            while (consequtive.get(current - 1) != null) {
                current_length++;
                current--;
            }
            current = num;
            while (consequtive.get(current + 1) != null) {
                current_length++;
                current++;
            }
            ans = Math.max(ans, current_length);
        }
        return ans;
    }
}
