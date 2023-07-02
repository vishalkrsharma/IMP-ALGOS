import java.util.ArrayList;
import java.util.Stack;

class Solution {

  class Pair {
    int v;
    int wt;

    Pair(int v, int wt) {
      this.v = v;
      this.wt = wt;
    }
  }

  static void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int vis[], Stack<Integer> st) {
    vis[node] = 1;
    for (int i = 0; i < adj.get(node).size(); i++) {
      int v = adj.get(node).get(i).v;
      if (vis[v] == 0) {
        topoSort(v, adj, vis, st);
      }
    }
    st.push(node);
  }

  public int[] shortestPath(int N, int M, int[][] edges) {
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      ArrayList<Pair> temp = new ArrayList<Pair>();
      adj.add(temp);
    }

    for (int i = 0; i < M; i++) {
      int u = edges[i][0];
      int v = edges[i][1];
      int wt = edges[i][2];
      adj.get(u).add(new Pair(v, wt));
    }

    int vis[] = new int[N];
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < N; i++) {
      if (vis[i] == 0) {
        topoSort(i, adj, vis, st);
      }
    }

    int dist[] = new int[N];
    for (int i = 0; i < N; i++) {
      dist[i] = (int) (1e9);
    }
    dist[0] = 0;
    while (!st.isEmpty()) {
      int node = st.pop();

      for (int i = 0; i < adj.get(node).size(); i++) {
        int v = adj.get(node).get(i).v;
        int wt = adj.get(node).get(i).wt;

        if (dist[node] + wt < dist[v]) {
          dist[v] = wt + dist[node];
        }
      }
    }

    for (int i = 0; i < N; i++) {
      if (dist[i] == (int) (1e9)) {
        dist[i] = -1;
      }
    }

    return dist;
  }
}