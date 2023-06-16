class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {

    int n = matrix.length, m = matrix[0].length;

    int low = 0, high = n * m - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (matrix[mid / m][mid % m] < target) {
        low = mid + 1;
      } else if (matrix[mid / m][mid % m] > target) {
        high = mid - 1;
      } else {
        return true;
      }
    }

    return false;
  }
}

// mid / m gives row
// mid % m gives column