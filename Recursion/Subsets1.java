import java.util.ArrayList;

class Solution {

  void calc(ArrayList<Integer> arr, int N, int i, int sum, ArrayList<Integer> res) {
    if (i == N) {
      res.add(sum);
      return;
    }

    calc(arr, N, i + 1, sum + arr.get(i), res);
    calc(arr, N, i + 1, sum, res);
  }

  ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
    ArrayList<Integer> res = new ArrayList<>();

    calc(arr, N, 0, 0, res);
    return res;
  }
}