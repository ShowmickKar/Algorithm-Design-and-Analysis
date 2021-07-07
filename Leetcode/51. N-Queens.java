/*
  Problem Link: https://leetcode.com/problems/n-queens/
  Problem Type: Backtracking, Depth First Search, Recursion, Iterating through Combinations
*/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        int[][] board = new int[n][n];
        search(board, n, result);
        return result;
    }

    private void search(int[][] board, int remaining, List<List<String>> result) {
        if (remaining == 0) {
            construct(board, result);
        }
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) continue;
                if (isSafePosition(board, i, j)) {
                    board[i][j] = 1;
                    search(board, remaining - 1, result);
                    board[i][j] = 0;
                }
            }
        }
    }

    private boolean isSafePosition(int[][] board, int i, int j) {
        int n = board.length;
        for (int r = 0; r < n; r++) {
            if (r == i) continue;
            if (board[r][j] == 1) {
                return false;
            }
        }
        for (int c = 0; c < n; c++) {
            if (c == j) continue;
            if (board[i][c] == 1) {
                return false;
            }
        }
        int r = i - 1, c = j - 1;
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 1) {
                return false;
            }
            r--;
            c--;
        }
        r = i + 1;
        c = j + 1;
        while (r < n && c < n) {
            if (board[r][c] == 1) {
                return false;
            }
            r++;
            c++;
        }
        r = i - 1;
        c = j + 1;
        while (r >= 0 && c < n) {
            if (board[r][c] == 1) {
                return false;
            }
            r--;
            c++;
        }
        r = i + 1;
        c = j - 1;
        while (r < n && c >= 0) {
            if (board[r][c] == 1) {
                return false;
            }
            r++;
            c--;
        }
        return true;
    }

    private void construct(int[][] board, List<List<String>> result) {
        int n = board.length;
        List<String> solution = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            String row = "";
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    row += 'Q';
                } else {
                    row += '.';
                }
            }
            solution.add(row);
        }
        for (List<String> s : result) {
            if (s.equals(solution)) {
                return;
            }
        }
        result.add(solution);
    }
}
