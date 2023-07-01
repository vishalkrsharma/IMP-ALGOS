import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

  class Pair {
    int node;
    int parent;

    Pair(int node, int parent) {
      this.node = node;
      this.parent = parent;
    }
  }

  public boolean checkForCycle(int src, int V, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
    vis[src] = true;
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(src, -1));

    while (!q.isEmpty()) {
      int node = q.peek().node;
      int parent = q.peek().parent;
      q.remove();

      for (int adjNode : adj.get(node)) {
        if (vis[adjNode] == false) {
          vis[adjNode] = true;
          q.add(new Pair(adjNode, node));
        } else if (parent != adjNode) {
          return true;
        }
      }
    }

    return false;
  }

  public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean vis[] = new boolean[V];
    for (int i = 0; i < V; i++) {
      if (vis[i] == false) {
        if (checkForCycle(i, V, adj, vis)) {
          return true;
        }

      }
    }

    return false;
  }
}