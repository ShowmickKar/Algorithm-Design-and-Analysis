Problem link: https://leetcode.com/problems/max-increase-to-keep-city-skyline/
Problem difficulty: Medium

class Solution {
public:
    int maxIncreaseKeepingSkyline(vector<vector<int>>& grid) {
        int ans = 0, r = grid.size();
        int row[r], column[r];
        for (int i = 0; i < r; ++i) {
            int m = 0;
            for (int j = 0; j < r; ++j) {
                m = max(m, grid[i][j]);
                row[i] = max(m, grid[i][j]);
            }
        }
        for (int j = 0; j < r; ++j) {
            int m = 0;
            for (int i = 0; i < r; ++i) {
                m = max(m, grid[i][j]); 
                column[j] = max(m, grid[i][j]);
            }    
        }
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < r; ++j) {
                ans += min(row[i], column[j]) - grid[i][j];
            }
        }
        return ans;
    }
};
