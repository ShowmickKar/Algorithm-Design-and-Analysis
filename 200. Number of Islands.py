Problem link: https://leetcode.com/problems/number-of-islands/
Problem Difficulty: Medium

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid == None or not len(grid):
            return 0
        ans = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == '1':
                    ans += self.explore(i, j, grid)
        return ans
    def explore(self, i, j, grid):
        if i < 0 or j < 0 or i >= len(grid) or j >= len(grid[i]) or grid[i][j] == '0':
            return 0
        grid[i][j] = '0'
        self.explore(i, j + 1, grid)
        self.explore(i, j - 1, grid)
        self.explore(i + 1, j, grid)
        self.explore(i - 1, j, grid)
        return 1
