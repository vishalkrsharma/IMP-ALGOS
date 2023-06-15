class Solution {
  public int[] repeatedNumber(final int[] A) {
    long len = A.length;

    long S = (len * (len + 1)) / 2;
    long P = (len * (len + 1) * (2 * len + 1)) / 6;

    // X = repeating number
    // Y = missing number
    long X = 0, Y = 0;

    for (int i = 0; i < A.length; i++) {
      S -= (long) A[i];
      P -= (long) A[i] * (long) A[i];
    }

    // S = X - Y
    // P = X^2 - Y^2

    X = (S + P / S) / 2;

    Y = X - S;

    int ans[] = new int[2];

    ans[0] = (int) X;
    ans[1] = (int) Y;

    return ans;
  }
}