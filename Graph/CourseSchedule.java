import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Check
class Solution1 {
  public boolean isPossible(int V, int[][] prerequisites) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    int m = prerequisites.length;
    for (int i = 0; i < m; i++) {
      adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
    }

    int indegree[] = new int[V];
    for (int i = 0; i < V; i++) {
      for (int it : adj.get(i)) {
        indegree[it]++;
      }
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < V; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    List<Integer> topo = new ArrayList<>();
    while (!q.isEmpty()) {
      int node = q.peek();
      q.remove();
      topo.add(node);

      for (int it : adj.get(node)) {
        indegree[it]--;
        if (indegree[it] == 0) {
          q.add(it);
        }
      }
    }

    return topo.size() == V;
  }
}

// Print
class Solution2 {
  static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
    }

    int indegree[] = new int[n];
    for (int i = 0; i < n; i++) {
      for (int it : adj.get(i)) {
        indegree[it]++;
      }
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    int topo[] = new int[n];
    int ind = 0;

    while (!q.isEmpty()) {
      int node = q.peek();
      q.remove();

      topo[ind++] = node;
      for (int it : adj.get(node)) {
        indegree[it]--;
        if (indegree[it] == 0) {
          q.add(it);
        }
      }
    }

    if (ind == n) {

      return topo;
    } else {
      return new int[] {};
    }
  }
}