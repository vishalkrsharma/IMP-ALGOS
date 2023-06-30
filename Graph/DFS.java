import java.util.ArrayList;

class Solution {

  public void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs) {
    vis[node] = true;
    dfs.add(node);

    for (Integer it : adj.get(node)) {
      if (vis[it] == false) {
        dfs(it, vis, adj, dfs);
      }
    }
  }

  public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean vis[] = new boolean[V];
    ArrayList<Integer> dfs = new ArrayList<>();

    dfs(0, vis, adj, dfs);
    return dfs;
  }
}