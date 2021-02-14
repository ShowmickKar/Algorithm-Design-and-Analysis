/* https://leetcode.com/problems/rotate-image/ */

class Solution {
    public void rotate(int[][] matrix) {
    	int n = matrix.length;
    	for (int i = 0; i < n; i++) {
    		for (int j = i + 1; j < n; j++) {
    			int temp = matrix[i][j];
    			matrix[i][j] = matrix[j][i];
    			matrix[j][i] = temp;
    		}
    	}
    	for (int i = 0; i < n; i++) {
    		int l = 0, u = n - 1;
    		while (l < u) {
    			int temp = matrix[i][l];
    			matrix[i][l] = matrix[i][u];
    			matrix[i][u] = temp;
    			l++;
    			u--;
    		}
    	}
    }
}
