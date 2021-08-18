/*
Problem Link: https://leetcode.com/problems/subsets/
Problem Type: Recursive Backtracking, DFS
*/

class Solution {
    private List<List<Integer>> store = new ArrayList<List<Integer>>();

    private void backtrack(int[] nums, int start, List<Integer> currentSubset) {
        if (start == nums.length) return;

        for (int i = start; i < nums.length; i++) {
            List<Integer> subset = new ArrayList<Integer>(currentSubset);
            subset.add(nums[i]);
            store.add(subset);
            backtrack(nums, i + 1, subset);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> emptySet = new ArrayList<Integer>();
        store.add(emptySet);
        backtrack(nums, 0, emptySet);
        return store;
    }
}
