import java.util.ArrayList;
import java.util.List;

class Solution {

  // Moore's Voting Algorithm for 2 numbers
  public List<Integer> majorityElement(int[] nums) {
    int num1 = 0, num2 = 0, c1 = 0, c2 = 0;

    for (int i = 0; i < nums.length; i++) {
      if (c1 == 0 && nums[i] != num2) {
        c1 = 1;
        num1 = nums[i];
      } else if (c2 == 0 && nums[i] != num1) {
        c2 = 1;
        num2 = nums[i];
      } else if (num1 == nums[i]) {
        c1++;
      } else if (num2 == nums[i]) {
        c2++;
      } else {
        c1--;
        c2--;
      }
    }

    List<Integer> ans = new ArrayList<Integer>();
    c1 = 0;
    c2 = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == num1) {
        c1++;
      } else if (nums[i] == num2) {
        c2++;
      }
    }

    if (c1 > nums.length / 3) {
      ans.add(num1);
    }

    if (c2 > nums.length / 3) {
      ans.add(num2);
    }

    return ans;
  }
}