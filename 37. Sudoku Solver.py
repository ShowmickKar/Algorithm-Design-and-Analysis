Problem Link: https://leetcode.com/problems/sudoku-solver/

class Solution:
    def isValid(self, board, guess, row, column):
        if guess in board[row]:
            return False
        column_cells = [board[i][column] for i in range(9)]
        if guess in column_cells:
            return False
        row_start = (row//3) * 3
        column_start = (column//3) * 3
        for i in range(row_start, row_start + 3):
            for j in range(column_start, column_start + 3):
                if board[i][j] == guess:
                    return False
        return True
    
    def findNextFreeSpot(self, board):
        for i in range(9):
            for j in range(9):
                if board[i][j] == ".":
                    return i, j
        return None, None
        
    def solve(self, board):
        row, column = self.findNextFreeSpot(board)
        if row == None:
            return True
        for guess in range(1, 10):
            if self.isValid(board, guess, row, column):
                board[row][column] = guess
                if self.solve(board):
                    return True
            board[row][column] = "."
        return False
                
    def solveSudoku(self, board: List[List[str]]) -> None:
        for i in range(9):
            for j in range(9):
                if board[i][j] != ".":
                    board[i][j] = int(board[i][j])

        print(board)
        self.solve(board)
        for i in range(9):
            for j in range(9):
                board[i][j] = str(board[i][j])  
