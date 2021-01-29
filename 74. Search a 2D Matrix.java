/* Problem Link: https://leetcode.com/problems/search-a-2d-matrix/ */

class Solution {
    private boolean searchRow(int[][] matrix, int row, int l, int u, int target) {
        if (l >= u) {
            return false;
        }
        int m = (l + u) / 2;
        if (target == matrix[row][m]) {
            return true;
        } else if (target < matrix[row][m]) {
            return searchRow(matrix, row, 0, m, target);
        } else if (target > matrix[row][m]) {
            return searchRow(matrix, row, m + 1, u, target);
        }
        return false;
    }

    private boolean findRow(int[][] matrix, int l, int u, int target) {
        if (l >= u) {
            return false;
        }
        int m = (l + u) / 2;
        if (target >= matrix[m][0] && target <= matrix[m][matrix[m].length - 1]) {
            return searchRow(matrix, m, 0, matrix[m].length, target);
        } else if (target < matrix[m][0]) {
            return findRow(matrix, 0, m, target);
        } else if (target > matrix[m][matrix[m].length - 1]) {
            return findRow(matrix, m + 1, u, target);
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        return findRow(matrix, 0, matrix.length, target);
    }
}
