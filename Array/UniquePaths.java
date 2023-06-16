import java.util.Arrays;

// DP Solution
class Solution1 {

  public int recur(int i, int j, int m, int n, int dp[][]) {
    if (i == m - 1 && j == n - 1)
      return 1;
    if (i >= m || j >= n)
      return 0;

    if (dp[i][j] != -1)
      return dp[i][j];

    return dp[i][j] = recur(i + 1, j, m, n, dp) + recur(i, j + 1, m, n, dp);

  }

  public int uniquePaths(int m, int n) {
    int dp[][] = new int[m + 1][n + 1];

    for (int i = 0; i < m; i++) {
      Arrays.fill(dp[i], -1);
    }

    return recur(0, 0, m, n, dp);

  }
}

/**
 * Direct Solution
 * (m+n-2)C(m-1) or (m+n-2)C(n-1)
 */
class Solution2 {
  public int uniquePaths(int m, int n) {
    int N = m + n - 2;
    int R = n - 1;

    int ans = 1;

    for (int i = 0; i < R; i++) {
      ans *= (N - i);
      ans /= (i + 1);
    }

    return ans;
  }
}