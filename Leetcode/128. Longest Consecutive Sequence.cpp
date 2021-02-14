/*Problem link: https://leetcode.com/problems/longest-consecutive-sequence/
 *Problem Difficulty: Hard
 *Time Complexity: O(N)
 *Space Complexity: O(N)
 *Runtime: 16 ms, faster than 87.19% of C++ online submissions for Longest Consecutive Sequence.
 *Memory Usage: 11.1 MB, less than 36.20% of C++ online submissions for Longest Consecutive Sequence.
*/ 

class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        int range = 0, ans = 0;
        unordered_map<int, bool> m;
        for (auto &u : nums) {
            m[u] = false;
        }
        for (auto &u : m) {
            if (u.second == true) continue;
            u.second = true;
            range = 1; 
            int n = u.first;
            while(m.find(n - 1) != m.end()) {
                ++range;
                m[n - 1] = true;
                --n;
            }
            n = u.first;
            while(m.find(n + 1) != m.end()) {
                ++range;
                m[n + 1] = true;
                ++n;
            }
            ans = max(ans, range);
        }
        return ans;
    }
};
