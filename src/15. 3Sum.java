// Problem Link: https://leetcode.com/problems/3sum/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> store = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int l = i + 1;
            int u = nums.length - 1;
            while (l < u) {
                if (nums[i] + nums[l] + nums[u] == 0) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[u]);
                    if (store.contains(temp) == false) {
                        store.add(temp);
                        ans.add(temp);
                    }
                    ++l;
                    --u;
                } else if (nums[i] + nums[l] + nums[u] < 0)
                    ++l;
                else
                    --u;
            }
        }
        return ans;
    }
}
