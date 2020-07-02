Problem link: https://leetcode.com/problems/max-increase-to-keep-city-skyline/
Problem difficulty: Medium

/*** Solution Detail **
 * TIme Complexity: O(N^2)
 * Space Complexity: O(N)
 * Runtime: 12 ms, faster than 93.43% of C++ online submissions for Max Increase to Keep City Skyline.
 * Memory Usage: 10.2 MB, less than 79.14% of C++ online submissions for Max Increase to Keep City Skyline.
 */

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
