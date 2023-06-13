class Solution {
  public void setZeroes(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;

    // for matrix[0][0] as it overlaps row and column checks
    // if first column contains 0 then col0=0
    // else 1
    int col0 = 1;

    for (int i = 0; i < n; i++) {

      // check if first column contains any 0
      if (matrix[i][0] == 0) {
        col0 = 0;
      }
      for (int j = 1; j < m; j++) {
        // make ith row and jth column=0
        if (matrix[i][j] == 0) {
          matrix[i][0] = matrix[0][j] = 0;
        }
      }
    }

    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 1; j--) {
        // check if row or column=0 then make all zero
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }

      // if matrix[0][0] contained 0 then make matrix[i][0]=0
      if (col0 == 0) {
        matrix[i][0] = 0;
      }
    }
  }
}