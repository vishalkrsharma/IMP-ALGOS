import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
  static class Pair {
    int node;
    int dist;

    Pair(int node, int dist) {
      this.node = node;
      this.dist = dist;
    }
  }

  static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.dist - y.dist);

    int dist[] = new int[V];
    for (int i = 0; i < V; i++) {
      dist[i] = (int) 1e9;
    }

    dist[S] = 0;
    pq.add(new Pair(S, 0));

    while (pq.size() != 0) {
      int node = pq.peek().node;
      int dis = pq.peek().dist;

      pq.remove();

      for (int i = 0; i < adj.get(node).size(); i++) {
        int adjNode = adj.get(node).get(i).get(0);
        int edgeWeight = adj.get(node).get(i).get(1);

        if (dis + edgeWeight < dist[adjNode]) {
          dist[adjNode] = dis + edgeWeight;
          pq.add(new Pair(adjNode, dist[adjNode]));
        }
      }
    }

    return dist;
  }
}