import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// By cycle detection
class Solution1 {

  private boolean dfs(int node, List<List<Integer>> adj, int vis[], int pathVis[], int check[]) {
    vis[node] = 1;
    pathVis[node] = 1;

    for (int it : adj.get(node)) {
      if (vis[it] == 0) {
        if (dfs(it, adj, vis, pathVis, check) == true) {
          return true;
        }
      } else if (pathVis[it] == 1) {
        return true;
      }
    }

    check[node] = 1;
    pathVis[node] = 0;
    return false;
  }

  List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
    int vis[] = new int[V];
    int pathVis[] = new int[V];
    int check[] = new int[V];

    for (int i = 0; i < V; i++) {
      if (vis[i] == 0) {
        dfs(i, adj, vis, pathVis, check);
      }
    }

    List<Integer> safeNodes = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      if (check[i] == 1) {
        safeNodes.add(i);
      }
    }

    return safeNodes;
  }
}

// By Topological Sort
class Solution2 {

  List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
    List<List<Integer>> adjRev = new ArrayList<>();

    for (int i = 0; i < V; i++) {
      adjRev.add(new ArrayList<>());
    }
    int indegree[] = new int[V];

    for (int i = 0; i < V; i++) {
      for (int it : adj.get(i)) {
        adjRev.get(it).add(i);
        indegree[i]++;
      }
    }

    Queue<Integer> q = new LinkedList<>();
    List<Integer> safeNodes = new ArrayList<>();

    for (int i = 0; i < V; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    while (!q.isEmpty()) {
      int node = q.peek();
      q.remove();
      safeNodes.add(node);

      for (int it : adjRev.get(node)) {
        indegree[it]--;
        if (indegree[it] == 0) {
          q.add(it);
        }
      }
    }

    Collections.sort(safeNodes);

    return safeNodes;
  }
}