import java.util.Arrays;

class Solution {

  boolean isSafe(int idx, int i, boolean graph[][], int color[], int n) {
    for (int k = 0; k < n; k++) {
      if (graph[idx][k] == true && color[k] == i) {
        return false;
      }
    }

    return true;
  }

  boolean helper(boolean graph[][], int m, int n, int color[], int idx) {
    if (idx == n)
      return true;

    for (int i = 0; i < m; i++) {
      if (isSafe(idx, i, graph, color, n)) {
        color[idx] = i;
        if (helper(graph, m, n, color, idx + 1))
          return true;

        color[idx] = -1;
      }
    }

    return false;
  }

  public boolean graphColoring(boolean graph[][], int m, int n) {
    int color[] = new int[n];
    Arrays.fill(color, -1);

    return helper(graph, m, n, color, 0);
  }
}