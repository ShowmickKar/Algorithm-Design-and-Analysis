/*
Problem Link: https://leetcode.com/problems/subsets/
Problem Type: Recursive Backtracking, DFS
*/

class Solution {
    private List<List<Integer>> store = new ArrayList<List<Integer>>();

    private void dfs(int[] nums, int index, List<Integer> currentSubset) {
        if (index == nums.length) return;

        for (int i = index; i < nums.length; i++) {
            List<Integer> subset = new ArrayList<Integer>(currentSubset);
            subset.add(nums[i]);
            store.add(subset);
            dfs(nums, i + 1, subset);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> emptySet = new ArrayList<Integer>();
        store.add(emptySet);
        dfs(nums, 0, emptySet);
        return store;
    }
}
