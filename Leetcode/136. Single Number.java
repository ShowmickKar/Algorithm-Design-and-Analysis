/* https://leetcode.com/problems/single-number/ */

// Approach: Using hashmap

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        for (int i : nums) {
            frequency.put(i, frequency.getOrDefault(i, 0) + 1);
        }
        for (int key : nums) {
            if (frequency.get(key) == 1) 
                return key;
        }
        return 0;
    }
}
