class Solution {
  public static int countStudents(int arr[], int pages) {
    int n = arr.length;
    int students = 1;
    long pagesStudent = 0;
    for (int i = 0; i < n; i++) {
      if (pagesStudent + arr[i] <= pages) {
        pagesStudent += arr[i];
      } else {
        students++;
        pagesStudent = arr[i];
      }
    }
    return students;

  }

  public static int findPages(int[] arr, int n, int m) {
    if (m > n)
      return -1;

    int low = Integer.MIN_VALUE, high = 0;

    for (int x : arr) {
      low = Math.max(low, x);
      high += x;
    }

    while (low <= high) {
      int mid = (low + high) / 2;
      int students = countStudents(arr, mid);
      if (students > m) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }
}