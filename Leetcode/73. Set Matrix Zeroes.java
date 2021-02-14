/* https://leetcode.com/problems/set-matrix-zeroes/ */

class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> row = new HashSet<Integer>();
        HashSet<Integer> column = new HashSet<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    column.add(j);
                }
            }
        }
        for (int i : row)
            for (int j = 0; j < matrix[0].length; j++)
                matrix[i][j] = 0;
        for (int i = 0; i < matrix.length; i++)
            for (int j : column)
                matrix[i][j] = 0;
    }
}
