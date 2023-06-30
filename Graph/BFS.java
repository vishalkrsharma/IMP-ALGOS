import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

    ArrayList<Integer> bfs = new ArrayList<>();
    boolean vis[] = new boolean[V];
    Queue<Integer> q = new LinkedList<>();

    q.add(0);
    vis[0] = true;

    while (!q.isEmpty()) {
      Integer node = q.poll();
      bfs.add(node);

      for (Integer l : adj.get(node)) {
        if (vis[l] == false) {
          vis[l] = true;
          q.add(l);
        }
      }
    }

    return bfs;

  }
}