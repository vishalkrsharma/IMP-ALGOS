import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  public boolean validate(char board[][], int row, int col) {
    int dupRow = row;
    int dupCol = col;

    while (row >= 0 && col >= 0) {
      if (board[row][col] == 'Q')
        return false;
      row--;
      col--;
    }

    row = dupRow;
    col = dupCol;

    while (col >= 0) {
      if (board[row][col] == 'Q')
        return false;
      col--;
    }

    row = dupRow;
    col = dupCol;

    while (col >= 0 && row < board.length) {
      if (board[row][col] == 'Q')
        return false;
      col--;
      row++;
    }

    return true;
  }

  public void dfs(int col, char board[][], List<List<String>> ans) {
    if (col == board.length) {
      ans.add(construct(board));
      return;
    }

    for (int row = 0; row < board.length; row++) {
      if (validate(board, row, col)) {
        board[row][col] = 'Q';
        dfs(col + 1, board, ans);
        board[row][col] = '.';
      }
    }
  }

  public List<String> construct(char[][] board) {
    List<String> res = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      String s = new String(board[i]);
      res.add(s);
    }

    return res;
  }

  public List<List<String>> solveNQueens(int n) {
    List<List<String>> ans = new ArrayList<>();
    char board[][] = new char[n][n];
    for (char x[] : board) {
      Arrays.fill(x, '.');
    }

    dfs(0, board, ans);
    return ans;
  }
}