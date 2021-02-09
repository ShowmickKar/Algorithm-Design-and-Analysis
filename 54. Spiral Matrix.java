/* https://leetcode.com/problems/spiral-matrix/ */

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    	int m = matrix.length, n = matrix[0].length;
    	List<Integer> spiral = new ArrayList<Integer>();
        int[] pos = {0, -1};
        while (spiral.size() < m * n) {
        	while (pos[1] + 1 < matrix[0].length && matrix[pos[0]][pos[1] + 1] <= 100) {
        		pos[1]++;
        		spiral.add(matrix[pos[0]][pos[1]]);
        		matrix[pos[0]][pos[1]] = 101;
        	}
        	while (pos[0] + 1 < matrix.length && matrix[pos[0] + 1][pos[1]] <= 100) {
        		pos[0]++;
        		spiral.add(matrix[pos[0]][pos[1]]);
        		matrix[pos[0]][pos[1]] = 101;        		
        	}
        	while (pos[1] > 0 && matrix[pos[0]][pos[1] - 1] <= 100) {
        		pos[1]--;
        		spiral.add(matrix[pos[0]][pos[1]]);
        		matrix[pos[0]][pos[1]] = 101;        		
        	}
        	while (pos[0] > 0 && matrix[pos[0] - 1][pos[1]] <= 100) {
        		pos[0]--;
        		spiral.add(matrix[pos[0]][pos[1]]);
        		matrix[pos[0]][pos[1]] = 101;        		
        	}
        }
        return spiral;
    }
}
