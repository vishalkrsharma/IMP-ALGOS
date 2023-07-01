import java.util.ArrayList;

class Solution {

  public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int vis[]) {
    vis[node] = 1;

    for (Integer i : adj.get(node)) {
      if (vis[i] == 0) {
        dfs(i, adj, vis);
      }
    }
  }

  static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
    ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();

    for (int i = 0; i < V; i++) {
      adjLs.add(new ArrayList<Integer>());
    }

    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++) {
        if (adj.get(i).get(j) == 1 && i != j) {
          adjLs.get(i).add(j);
          adjLs.get(j).add(i);
        }
      }
    }

    int vis[] = new int[V];
    int c = 0;

    for (int i = 0; i < V; i++) {
      if (vis[i] == 0) {
        dfs(i, adjLs, vis);
        c++;
      }
    }

    return c;
  }
}