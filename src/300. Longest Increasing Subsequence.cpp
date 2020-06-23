Problem link: https://leetcode.com/problems/longest-increasing-subsequence/
Problem Difficulty: Medium.

class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int> length(nums.size());
        int ans = (nums.size() > 0 ? 1 : 0);
        for (int k = 0; k < nums.size(); ++k) {
            length[k] = 1;
            for (int i = 0; i < k; ++i) {
                if (nums[i] < nums[k]) {
                    length[k] = max(length[k], length[i] + 1);
                    ans = max(ans, length[k]);
                }
            }
        }
        return ans;
    }
};
