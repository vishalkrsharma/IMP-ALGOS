import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public void calc(int ind, int nums[], int target, List<Integer> ds, List<List<Integer>> ans) {
    if (target == 0) {
      ans.add(new ArrayList<>(ds));
      return;
    }

    for (int i = ind; i < nums.length; i++) {
      if (i != ind && nums[i] == nums[i - 1])
        continue;
      if (nums[i] > target)
        break;

      ds.add(nums[i]);
      calc(i + 1, nums, target - nums[i], ds, ans);
      ds.remove(ds.size() - 1);

    }
  }

  public List<List<Integer>> combinationSum2(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();

    calc(0, nums, target, new ArrayList<>(), ans);

    return ans;
  }
}