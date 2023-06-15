import java.util.ArrayList;
import java.util.List;

class Solution {

  // 1. print sum
  public int maxSubArraySum(int[] nums) {
    int max = Integer.MIN_VALUE, sum = 0;

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (sum > max) {
        max = sum;
      }

      // when sum<=0 make it 0
      if (sum < 0) {
        sum = 0;
      }
    }

    return max;
  }

  // 2. print array
  public List<Integer> maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE, sum = 0;
    int start = -1;
    int ansStart = -1, ansEnd = -1;
    List<Integer> ans = new ArrayList<Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (sum == 0) {
        start = i;
      }
      sum += nums[i];

      if (sum > max) {
        max = sum;
        ansStart = start;
        ansEnd = i;
      }

      // when sum<=0 make it 0
      if (sum < 0) {
        sum = 0;
      }
    }

    for (int i = ansStart; i <= ansEnd; i++) {
      ans.add(nums[i]);
    }

    return ans;
  }
}