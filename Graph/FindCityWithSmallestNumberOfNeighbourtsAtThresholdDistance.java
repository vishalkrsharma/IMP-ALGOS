class Solution {
  int findCity(int n, int m, int[][] edges, int distanceThreshold) {
    int matrix[][] = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = Integer.MAX_VALUE;
        if (i == j)
          matrix[i][j] = 0;
      }
    }

    for (int i = 0; i < m; i++) {
      matrix[edges[i][0]][edges[i][1]] = edges[i][2];
      matrix[edges[i][1]][edges[i][0]] = edges[i][2];
    }

    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (matrix[i][k] == Integer.MAX_VALUE || matrix[k][j] == Integer.MAX_VALUE)
            continue;
          matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
        }
      }
    }

    int cntCity = n;
    int cityNo = -1;
    for (int city = 0; city < n; city++) {
      int cnt = 0;
      for (int adjCity = 0; adjCity < n; adjCity++) {
        if (matrix[city][adjCity] <= distanceThreshold)
          cnt++;
      }

      if (cnt <= cntCity) {
        cntCity = cnt;
        cityNo = city;
      }
    }

    return cityNo;

  }
}