import java.util.LinkedList;
import java.util.Queue;

// BFS
class Solution1 {

  class Pair {
    int first;
    int second;

    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }

  private void bfs(int ro, int co, int vis[][], char[][] grid) {
    vis[ro][co] = 1;
    Queue<Pair> q = new LinkedList<Pair>();
    int n = grid.length;
    int m = grid[0].length;

    q.add(new Pair(ro, co));

    while (!q.isEmpty()) {
      int row = q.peek().first;
      int col = q.peek().second;

      q.remove();

      for (int delRow = -1; delRow <= 1; delRow++) {
        for (int delCol = -1; delCol <= 1; delCol++) {
          int nRow = row + delRow;
          int nCol = col + delCol;

          if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == '1' && vis[nRow][nCol] == 0) {
            vis[nRow][nCol] = 1;
            q.add(new Pair(nRow, nCol));
          }
        }
      }
    }
  }

  public int numIslands(char[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int c = 0;
    int vis[][] = new int[n][m];
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < m; col++) {
        if (vis[row][col] == 0 && grid[row][col] == '1') {
          c++;
          bfs(row, col, vis, grid);
        }
      }
    }

    return c;
  }
}

// DFS
class Solution2 {
  public int numIslands(char[][] grid) {
    int c = 0;
    int n = grid.length;
    int m = grid[0].length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == '1') {
          calc(grid, i, j, n, m);
          c++;
        }
      }
    }
    return c;
  }

  public void calc(char grid[][], int i, int j, int row, int col) {
    if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0')
      return;

    grid[i][j] = '0';

    calc(grid, i + 1, j, row, col);
    calc(grid, i - 1, j, row, col);
    calc(grid, i, j + 1, row, col);
    calc(grid, i, j - 1, row, col);
  }
}