import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

  static class Pair {
    int node;
    long dist;

    Pair(int node, long dist) {
      this.node = node;
      this.dist = dist;
    }
  }

  static int countPaths(int n, List<List<Integer>> roads) {
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }
    int m = roads.size();
    for (int i = 0; i < m; i++) {
      adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1), roads.get(i).get(2)));
      adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0), roads.get(i).get(2)));
    }

    PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> (int) (x.dist - y.dist));
    long dist[] = new long[n];
    int ways[] = new int[n];
    for (int i = 0; i < n; i++) {
      dist[i] = Long.MAX_VALUE;
      ways[i] = 0;
    }
    dist[0] = 0;
    ways[0] = 1;
    pq.add(new Pair(0, 0));
    int mod = (int) (1e9 + 7);

    while (pq.size() != 0) {
      int node = pq.peek().node;
      long dis = pq.peek().dist;
      pq.remove();

      for (Pair it : adj.get(node)) {
        int adjNode = it.node;
        long edW = it.dist;

        if (dis + edW < dist[adjNode]) {
          dist[adjNode] = dis + edW;
          pq.add(new Pair(adjNode, dis + edW));
          ways[adjNode] = ways[node];
        } else if (dis + edW == dist[adjNode]) {
          ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
        }

      }
    }

    return ways[n - 1] % mod;
  }
}