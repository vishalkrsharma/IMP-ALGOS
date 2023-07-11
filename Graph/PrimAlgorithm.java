import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {

  static class Pair {
    int node;
    int dist;

    Pair(int dist, int node) {
      this.node = node;
      this.dist = dist;
    }
  }

  static int spanningTree(int V, int E, int edges[][]) {

    ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<ArrayList<Integer>>());
    }
    for (int i = 0; i < E; i++) {
      int u = edges[i][0];
      int v = edges[i][1];
      int w = edges[i][2];

      ArrayList<Integer> tmp1 = new ArrayList<Integer>();
      ArrayList<Integer> tmp2 = new ArrayList<Integer>();
      tmp1.add(v);
      tmp1.add(w);

      tmp2.add(u);
      tmp2.add(w);

      adj.get(u).add(tmp1);
      adj.get(v).add(tmp2);
    }

    PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);
    int vis[] = new int[V];

    pq.add(new Pair(0, 0));
    int sum = 0;

    while (pq.size() > 0) {
      int wt = pq.peek().dist;
      int node = pq.peek().node;
      pq.remove();

      if (vis[node] == 1)
        continue;

      vis[node] = 1;
      sum += wt;

      for (int i = 0; i < adj.get(node).size(); i++) {
        int edW = adj.get(node).get(i).get(1);
        int adjNode = adj.get(node).get(i).get(0);
        if (vis[adjNode] == 0) {
          pq.add(new Pair(edW, adjNode));
        }
      }
    }

    return sum;
  }
}