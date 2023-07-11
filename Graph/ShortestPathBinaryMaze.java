import java.util.LinkedList;
import java.util.Queue;

class Solution {

  class Tuple {
    int dist, row, col;

    Tuple(int dist, int row, int col) {
      this.dist = dist;
      this.row = row;
      this.col = col;
    }
  }

  int shortestPath(int[][] grid, int[] source, int[] destination) {
    if (source[0] == destination[0] && source[1] == destination[1])
      return 0;

    Queue<Tuple> q = new LinkedList<>();
    int n = grid.length;
    int m = grid[0].length;
    int dist[][] = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        dist[i][j] = (int) (1e9);
      }
    }

    dist[source[0]][source[1]] = 0;
    q.add(new Tuple(0, source[0], source[1]));

    int dr[] = { -1, 0, 1, 0 };
    int dc[] = { 0, 1, 0, -1 };

    while (!q.isEmpty()) {
      Tuple it = q.peek();
      int dis = it.dist;
      int r = it.row;
      int c = it.col;
      q.remove();

      for (int i = 0; i < 4; i++) {
        int newR = r + dr[i];
        int newC = c + dc[i];

        if (newR >= 0 && newR < n && newC >= 0 && newC < m && grid[newR][newC] == 1 && dis + 1 < dist[newR][newC]) {
          dist[newR][newC] = dis + 1;
          if (newR == destination[0] && newC == destination[1])
            return dis + 1;
          q.add(new Tuple(1 + dis, newR, newC));
        }
      }
    }

    return -1;
  }
}