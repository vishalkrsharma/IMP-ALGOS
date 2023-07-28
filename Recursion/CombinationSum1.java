import java.util.ArrayList;
import java.util.List;

class Solution {
  public void calc(int ind, int nums[], int target, List<Integer> ds, List<List<Integer>> ans) {
    if (ind == nums.length) {
      if (target == 0) {
        ans.add(new ArrayList<>(ds));
      }
      return;
    }

    if (nums[ind] <= target) {
      ds.add(nums[ind]);
      calc(ind, nums, target - nums[ind], ds, ans);
      ds.remove(ds.size() - 1);
    }
    calc(ind + 1, nums, target, ds, ans);

  }

  public List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> ans = new ArrayList<>();

    calc(0, nums, target, new ArrayList<>(), ans);

    return ans;
  }
}