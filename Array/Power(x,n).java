class Solution {
  public double myPow(double x, int n) {
    double ans = 1.0;

    // long because absolute lowest negative int value cannot be stored in int
    long nn = n;

    if (nn < 0)
      nn *= -1;

    while (nn > 0) {
      if (nn % 2 == 1) {
        ans = ans * x;
        nn--;
      } else {
        x = x * x;
        nn /= 2;
      }
    }
    if (n < 0) {
      return (double) (1.0) / (double) ans;
    } else {
      return ans;
    }
  }
}