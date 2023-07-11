import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

  class Pair {
    int noperation;
    int muln;

    Pair(int noperation, int muln) {
      this.noperation = noperation;
      this.muln = muln;
    }
  }

  int minimumMultiplications(int[] arr, int start, int end) {
    int mod = (int) (1e5);
    int dist[] = new int[mod + 1];
    Arrays.fill(dist, (int) 1e9);
    dist[start] = 0;
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(0, start));
    while (!q.isEmpty()) {
      Pair curr = q.poll();
      int onoperation = curr.noperation;
      int omuln = curr.muln;
      if (omuln == end)
        return dist[omuln];
      for (int i = 0; i < arr.length; i++) {
        int newmuln = (omuln * arr[i]) % mod;
        if (dist[newmuln] > (onoperation + 1)) {
          dist[newmuln] = onoperation + 1;
          q.add(new Pair(dist[newmuln], newmuln));
        }
      }
    }
    return -1;
  }
}