import java.util.HashMap;
import java.util.Map;

// Map Solution
class Solution1 {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    int ans[] = new int[2];

    for (int i = 0; i < nums.length; i++) {
      int curr = target - nums[i];
      if (map.containsKey(curr)) {
        ans[0] = i;
        ans[1] = map.get(curr);
        break;
      }

      map.put(nums[i], i);
    }

    return ans;

  }
}