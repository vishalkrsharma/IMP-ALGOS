class Solution {s
  public static long merge(long arr[], int l, int m, int r) {
    int left = l;
    int right = m + 1;
    int c = 0, i = 0;

    long temp[] = new long[r - l + 1];

    while (left <= m && right <= r) {
      if (arr[left] <= arr[right]) {
        temp[i++] = arr[left++];
      } else {
        temp[i++] = arr[right++];

        // count all the number on the right of left pointer till m
        c += (m - left + 1);
      }
    }

    while (left <= m) {
      temp[i++] = arr[left++];
    }

    while (right <= r) {
      temp[i++] = arr[right++];
    }

    for (i = l; i <= r; i++) {
      arr[i] = temp[i - l];
    }

    return c;

  }

  public static long mergeSort(long arr[], int l, int r) {
    int inv = 0;

    if (l < r) {
      int m = (l + r) / 2;

      inv += mergeSort(arr, l, m);
      inv += mergeSort(arr, m + 1, r);

      inv += merge(arr, l, m, r);
    }

    return inv;
  }

  public static long getInversions(long arr[], int n) {
    return mergeSort(arr, 0, n - 1);
  }
}