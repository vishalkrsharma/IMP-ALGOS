import java.util.PriorityQueue;

class Solution {
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int x : nums) {
      pq.add(-1 * x);
    }
    k--;
    while (k-- > 0) {
      pq.remove();
    }

    return pq.remove() * -1;
  }
}