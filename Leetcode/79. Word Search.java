/* Problem Link: https://leetcode.com/problems/word-search/ */

class Solution {
    public boolean visited[][];
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && search(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }
    
    public boolean search(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) return true;
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || visited[i][j] || board[i][j] != word.charAt(index)) return false;
        visited[i][j] = true;
        if (
            search(board, i + 1, j, word, index + 1) || 
            search(board, i - 1, j, word, index + 1) || 
            search(board, i, j + 1, word, index + 1) || 
            search(board, i, j - 1, word, index + 1)
        ) { return true;}
        visited[i][j]= false;
        return false;
    }
}
