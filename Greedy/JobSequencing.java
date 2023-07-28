import java.util.Arrays;

class Job {
  int id, profit, deadline;

  Job(int x, int y, int z) {
    this.id = x;
    this.deadline = y;
    this.profit = z;
  }
}

class Solution {
  int[] JobScheduling(Job arr[], int n) {
    Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

    int max = 0;

    for (int i = 0; i < n; i++) {
      max = Math.max(max, arr[i].deadline);
    }

    int ans[] = new int[max + 1];

    for (int i = 1; i < max + 1; i++) {
      ans[i] = -1;
    }

    int c = 0, pro = 0;

    for (int i = 0; i < n; i++) {
      for (int j = arr[i].deadline; j > 0; j--) {
        if (ans[j] == -1) {
          ans[j] = i;
          c++;
          pro += arr[i].profit;
          break;
        }
      }
    }

    return new int[] { c, pro };
  }
}
