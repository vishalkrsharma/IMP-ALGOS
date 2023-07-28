import java.util.ArrayList;
import java.util.List;

class Solution {

  private void func(int idx, int nums[], List<List<Integer>> ans) {
    if (idx == nums.length) {
      List<Integer> ds = new ArrayList<>();
      for (int i = 0; i < nums.length; i++) {
        ds.add(nums[i]);
      }
      ans.add(new ArrayList<>(ds));
      return;
    }

    for (int i = idx; i < nums.length; i++) {
      swap(i, idx, nums);
      func(idx + 1, nums, ans);
      swap(i, idx, nums);
    }
  }

  private void swap(int i, int j, int nums[]) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();

    func(0, nums, ans);

    return ans;
  }
}