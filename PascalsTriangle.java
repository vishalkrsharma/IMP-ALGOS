import java.util.ArrayList;
import java.util.List;

class Solution {
  // 1. Print triangle
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> row, pre = null;
    for (int i = 0; i < numRows; i++) {
      // make list for new row
      row = new ArrayList<Integer>();
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          // add 1 to first and last element of row
          row.add(1);
        } else {
          row.add(pre.get(j - 1) + pre.get(j));
        }
      }

      // row to prev row
      pre = row;

      res.add(row);
    }
    return res;
  }

  /**
   * 2. Get value at row=r col=c
   * (r-1)C(c-1)
   */
  int nCr(int r, int c) {
    int res = 1;
    for (int i = 0; i < c; i++) {
      res = res * (r - i);
      res = res / (i + 1);
    }
    return res;
  }

  /**
   * 3. Print nth row
   * nth row will have n columns
   */
  List<Integer> generateRow(int n) {
    List<Integer> list = new ArrayList<Integer>();
    int curr = 1;
    list.add(curr);
    for (int i = 1; i < n; i++) {
      curr *= (n - i);
      curr /= i;
      list.add(curr);
    }
    return list;
  }
}
