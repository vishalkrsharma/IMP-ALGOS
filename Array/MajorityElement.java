class Solution {

  // Moore's Voting Algorithm
  public int majorityElement(int[] nums) {
    int curr = 0;
    int c = 0;

    for (int i = 0; i < nums.length; i++) {
      if (c == 0) {
        curr = nums[i];
      }
      if (nums[i] == curr) {
        c++;
      } else {
        c--;
      }
    }

    // following lines not needed if majority element always exists
    c = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == curr)
        c++;
    }

    if (c > nums.length / 2)
      return curr;
    else
      return -1;
  }
}