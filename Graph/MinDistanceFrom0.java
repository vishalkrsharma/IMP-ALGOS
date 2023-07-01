import java.util.LinkedList;
import java.util.Queue;

class Solution {

  class Node {
    int row;
    int col;
    int steps;

    Node(int row, int col, int steps) {
      this.row = row;
      this.col = col;
      this.steps = steps;
    }
  }

  public int[][] updateMatrix(int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;
    int vis[][] = new int[n][m];
    int dist[][] = new int[n][m];
    Queue<Node> q = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (mat[i][j] == 0) {
          vis[i][j] = 1;
          q.add(new Node(i, j, 0));
        } else {
          vis[i][j] = 0;
        }
      }
    }

    int delRow[] = { -1, 0, +1, 0 };
    int delCol[] = { 0, +1, 0, -1 };

    while (!q.isEmpty()) {
      int row = q.peek().row;
      int col = q.peek().col;
      int steps = q.peek().steps;
      q.remove();
      dist[row][col] = steps;

      for (int i = 0; i < 4; i++) {
        int nRow = row + delRow[i];
        int nCol = col + delCol[i];

        if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && vis[nRow][nCol] == 0) {
          vis[nRow][nCol] = 1;
          q.add(new Node(nRow, nCol, steps + 1));
        }
      }
    }
    return dist;
  }
}