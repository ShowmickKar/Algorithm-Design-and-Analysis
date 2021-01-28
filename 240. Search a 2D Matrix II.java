/*
  Problem Link: https://leetcode.com/problems/merge-two-binary-trees/
*/

class Solution {
    public boolean helperFunction(int[][] matrix, int target, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == 1000000001) {
            return false;
        }
        if (matrix[i][j] == target) {
            return true;
        }
        if (matrix[i][j] < target) {
            matrix[i][j] = 1000000001;
            return ((helperFunction(matrix, target, i + 1, j) || (helperFunction(matrix, target, i, j + 1))));
        }
        if (matrix[i][j] > target) {
            matrix[i][j] = 1000000001;
            return ((helperFunction(matrix, target, i - 1, j) || (helperFunction(matrix, target, i, j - 1))));
        } else
            return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        return helperFunction(matrix, target, matrix.length / 2, matrix[0].length / 2);
    }
}
