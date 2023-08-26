import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
  static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
    Arrays.sort(A);
    Arrays.sort(B);
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int a = N - 1, b = N - 1;

    for (int j = N - 1; j > N - K - 1; j--) {
      for (int k = N - 1; k > N - K - 1; k--) {
        int n = A[j] + B[k];
        if (pq.size() < K)
          pq.add(n);
        else {
          if (pq.peek() < n) {
            pq.poll();
            pq.add(n);
          } else
            break;
        }
      }
    }
    List<Integer> ans = new ArrayList<>();
    while (!pq.isEmpty()) {
      if (ans.isEmpty())
        ans.add(pq.poll());
      else
        ans.add(0, pq.poll());
    }

    return ans;
  }
}