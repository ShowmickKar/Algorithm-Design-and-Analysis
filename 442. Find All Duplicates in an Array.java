/* https://leetcode.com/problems/find-all-duplicates-in-an-array/ */

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> duplicates = new ArrayList<Integer>();
        
        for (int i = 0; i < n; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0) {
                duplicates.add(Math.abs(nums[i]));
            } else {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        return duplicates;
    }
}
