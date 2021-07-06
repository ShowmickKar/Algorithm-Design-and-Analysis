/*
 Problem Link: https://leetcode.com/problems/number-of-islands/
 Problem Type: Depth First Search, Recursion
*/

class Solution {
    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands++;
                    depthFirstSearch(grid, i, j);
                }
            }
        }
        return numberOfIslands;
    }

    private void depthFirstSearch(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 'n';
        depthFirstSearch(grid, i + 1, j);
        depthFirstSearch(grid, i - 1, j);
        depthFirstSearch(grid, i, j + 1);
        depthFirstSearch(grid, i, j - 1);
    }
}
