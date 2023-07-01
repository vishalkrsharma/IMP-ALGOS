import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// GFG
class Solution1 {

  public boolean check(int start, int V, ArrayList<ArrayList<Integer>> adj, int color[]) {
    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    color[start] = 0;

    while (!q.isEmpty()) {
      int node = q.peek();
      q.remove();

      for (int it : adj.get(node)) {
        if (color[it] == -1) {
          color[it] = 1 - color[node];
          q.add(it);
        } else if (color[it] == color[node]) {
          return false;
        }
      }
    }

    return true;
  }

  public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
    int color[] = new int[V];
    Arrays.fill(color, -1);

    for (int i = 0; i < V; i++) {
      if (color[i] == -1) {
        if (check(i, V, adj, color) == false) {
          return false;
        }
      }
    }

    return true;
  }
}

// Leetcode
class Solution2 {

  public boolean validColor(int graph[][], int color[], int c, int node) {
    if (color[node] != 0) {
      return color[node] == c;
    }

    color[node] = c;

    for (int n : graph[node]) {
      if (!validColor(graph, color, -c, n))
        return false;
    }

    return true;
  }

  public boolean isBipartite(int[][] graph) {
    int V = graph.length;
    int color[] = new int[V];

    for (int i = 0; i < V; i++) {
      if (color[i] == 0 && !validColor(graph, color, 1, i)) {
        return false;
      }
    }

    return true;
  }
}