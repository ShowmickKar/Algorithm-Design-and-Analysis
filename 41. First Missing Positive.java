/* Problem Link: https://leetcode.com/problems/first-missing-positive/ */

// Approach 1(Using Sorting): Time Complexity: O(nlogn) Space Complexity: O(1)

class Solution {
    public int firstMissingPositive(int[] nums) {
        int ans = 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (nums[i] == ans)
                    ans++;
                else if (nums[i] < ans)
                    continue;
                else
                    return ans;
            }
        }
        return ans;
    }
}

// Approach 2(Using HashMap): Time Complexity: O(n) Space Complexity: O(n)

class Solution {
    public int firstMissingPositive(int[] nums) {
        int ans = 1;
        HashMap<Integer, Boolean> store  = new HashMap<Integer, Boolean>();
        for (int i = 0; i < nums.length; i++) store.put(nums[i], true);
        for (int i = 1; i <= nums.length; i++) {
            if (store.get(i) == null)
                return i;
            else ++ans;
        }
        return ans;
    }
}

// Approach 3(Using Logical Deduction & negative indexing): Time Complexity: O(n) Space Complexity: O(1)

class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1 || nums[i] > nums.length)
                nums[i] = nums.length + 1;
        }
        for (int i = 0; i < nums.length; i++) {
            int n = Math.abs(nums[i]);
            if (n <= nums.length) {
                nums[n - 1] = Math.abs(nums[n - 1]) * -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                return ++i;
        }
        return nums.length + 1;
    }
}
