// 1. Formula Math.min(preMax[i], sufMax[i])-height[i]
class Solution1 {
  public int trap(int[] height) {
    int n = height.length;
    int preMax[] = new int[n];
    int sufMax[] = new int[n];

    int mx = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      preMax[i] = Math.max(height[i], mx);
      mx = preMax[i];
    }

    mx = Integer.MIN_VALUE;

    for (int i = n - 1; i >= 0; i--) {
      sufMax[i] = Math.max(height[i], mx);
      mx = sufMax[i];
    }

    int ans = 0;

    for (int i = 0; i < n; i++) {
      ans += Math.min(preMax[i], sufMax[i]) - height[i];
    }

    return ans;
  }
}

// 2.
class Solution2 {
  public int trap(int[] height) {
    int n = height.length;
    int left = 0, right = n - 1;
    int leftMax = 0, rightMax = 0;
    int ans = 0;

    while (left < right) {
      if (height[left] < height[right]) {
        if (height[left] >= leftMax) {
          leftMax = height[left];
        } else {
          ans += leftMax - height[left];
        }
        left++;
      } else {
        if (height[right] >= rightMax) {
          rightMax = height[right];
        } else {
          ans += rightMax - height[right];
        }
        right--;
      }
    }

    return ans;
  }
}