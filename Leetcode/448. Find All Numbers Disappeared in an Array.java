/* https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/ */

// Approach 1(Using Hashmap): Time Complexity O(N) Space Complexity O(N)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	List<Integer> missing_numbers = new ArrayList<Integer>();
        HashMap<Integer, Boolean> is_present = new HashMap<Integer, Boolean>();
        
        for (int i = 0; i < nums.length; i++) {
        	is_present.put(nums[i], true);
        }
        
        for (int i = 1; i < nums.length + 1; i++) {
        	if (is_present.get(i) == null) {
        		missing_numbers.add(i);
        	}
        }
        return missing_numbers;
    }
}

// Approach 2(Negative Indexing) ime Complexity O(N) Space Complexity O(1)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	List<Integer> missing_numbers = new ArrayList<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
        	nums[Math.abs(nums[i]) - 1] = Math.abs(nums[Math.abs(nums[i]) - 1]) * -1;
        }
        
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] > 0) {
        		missing_numbers.add(i + 1);
        	}
        }
        return missing_numbers;
    }
}
