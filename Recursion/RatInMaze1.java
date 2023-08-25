import java.util.ArrayList;

class Solution {

  public static void helper(int row, int col, int m[][], int n, ArrayList<String> res, String curr, int vis[][]) {

    if (row == n - 1 && col == n - 1) {
      res.add(curr);
      return;
    }

    if (row + 1 < n && vis[row + 1][col] != 1 && m[row + 1][col] == 1) {
      vis[row][col] = 1;
      helper(row + 1, col, m, n, res, curr + "D", vis);
      vis[row][col] = 0;
    }

    if (col - 1 >= 0 && vis[row][col - 1] != 1 && m[row][col - 1] == 1) {
      vis[row][col] = 1;
      helper(row, col - 1, m, n, res, curr + "L", vis);
      vis[row][col] = 0;
    }

    if (col + 1 < n && vis[row][col + 1] != 1 && m[row][col + 1] == 1) {
      vis[row][col] = 1;
      helper(row, col + 1, m, n, res, curr + "R", vis);
      vis[row][col] = 0;
    }

    if (row - 1 >= 0 && vis[row - 1][col] != 1 && m[row - 1][col] == 1) {
      vis[row][col] = 1;
      helper(row - 1, col, m, n, res, curr + "U", vis);
      vis[row][col] = 0;
    }

  }

  public static ArrayList<String> findPath(int[][] m, int n) {
    ArrayList<String> res = new ArrayList<>();
    if (m[0][0] == 0)
      return res;
    int vis[][] = new int[n][n];
    helper(0, 0, m, n, res, "", vis);

    return res;
  }
}