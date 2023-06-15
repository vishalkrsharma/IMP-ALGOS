class Solution {
  void merge(int arr[], int l, int m, int r) {

    // temp array
    int temp[] = new int[r - l + 1];
    int left = l;
    int right = m + 1;

    int i = 0;

    while (left <= m && right <= r) {
      if (arr[left] < arr[right]) {
        temp[i++] = arr[left++];
      } else {
        temp[i++] = arr[right++];
      }
    }

    while (left <= m) {
      temp[i++] = arr[left++];
    }

    while (right <= r) {
      temp[i++] = arr[right++];
    }

    // copy temp array to original array
    for (i = l; i <= r; i++) {
      arr[i] = temp[i - l];
    }
  }

  void mergeSort(int arr[], int l, int r) {
    if (l < r) {
      int m = (l + r) / 2;
      mergeSort(arr, l, m);
      mergeSort(arr, m + 1, r);
      merge(arr, l, m, r);
    }
  }
}