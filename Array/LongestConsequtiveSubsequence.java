import java.util.Arrays;

// loop solution(better)
class Solution1 {
  public int longestConsecutive(int[] nums) {
    if (nums.length == 0 || nums == null) {
      return 0;
    }

    Arrays.sort(nums);

    int ans = 1;
    int prev = nums[0];
    int cur = 1;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == prev + 1) {
        cur++;
      } else if (nums[i] != prev) {
        cur = 1;
      }
      prev = nums[i];
      ans = Math.max(ans, cur);
    }
    return ans;
  }
}

// optimal
class Solution2 {
  public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();

    for (int x : nums) {
      set.add(x);
    }

    int max = 0;

    for (int x : nums) {
      if (!set.contains(x - 1)) {
        int currNum = x;
        int currMax = 1;

        while (set.contains(currNum + 1)) {
          currNum++;
          currMax++;
        }

        max = Math.max(max, currMax);
      }
    }

    return max;

  }
}