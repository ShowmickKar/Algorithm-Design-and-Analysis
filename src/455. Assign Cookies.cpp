problem link: https://leetcode.com/problems/assign-cookies/

class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        int cnt = 0;
        sort (g.begin(), g.end());
        sort (s.begin(), s.end());
        int i = 0, j = 0;
        while (i < g.size() && j < s.size()) {
            if (g[i] <= s[j]) {
                cnt++;
                i++;
                j++;
            }
            else j++;
        }
        return cnt;
    }
};
