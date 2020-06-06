problem link: https://leetcode.com/problems/two-city-scheduling/

/* Solution detail **********
 *Runtime: 4 ms, faster than 99.03% of C++ online submissions for Two City Scheduling.
 *Memory Usage: 8.3 MB, less than 24.41% of C++ online submissions for Two City Scheduling. */

class Solution {
public:
    int twoCitySchedCost(vector<vector<int>>& costs) {
        int ans = 0, ans2 = 0;
        vector<pair<int, pair<int, int>>> a(2*costs.size());
        vector<pair<int, pair<int, int>>> b(2*costs.size());
        for (int i = 0; i < costs.size(); i++) {
            b[i].first = costs[i][1] - costs[i][0];
            b[i].second.first = costs[i][1];
            b[i].second.second = costs[i][0];
            a[i].first = costs[i][0] - costs[i][1];
            a[i].second.first = costs[i][0];
            a[i].second.second = costs[i][1];
        }
        sort (a.begin(), a.end());
        sort (b.begin(), b.end());
        for (int i = 0; i < a.size(); i++) {
            ans2 += (i < costs.size()/2 ? b[i].second.first : b[i].second. second);
        }
        for (int i = 0; i < a.size(); i++) {
            ans += (i < costs.size()/2 ? a[i].second.first : a[i].second. second);
        }
        return max(ans, ans2);
    }
};
