class Solution {
  public void nextPermutation(int[] nums) {

    int n = nums.length - 2;
    int idx = -1;

    // go to index where nums[i]<nums[i+1] =idx
    for (int i = n - 2; i >= 0; i--) {
      if (nums[i] < nums[i + 1]) {
        idx = i;
        break;
      }
    }

    /**
     * if idx=-1
     * then the last permutation is given eg {5,4,3,2,1}
     * then result will be first permutation eg {1,2,3,4,5}
     * so just reverse the given array
     */
    if (idx == -1) {
      reverse(nums, 0, n - 1);
      return;
    }

    /**
     * if idx!=-1
     * then find nums[i]>nums[idx] but smallest and swap them
     */
    for (int i = n - 1; i >= 0; i--) {
      if (nums[i] > nums[idx]) {
        System.out.println(i + " " + idx);
        swap(nums, idx, i);
        break;
      }
    }

    reverse(nums, idx + 1, n - 1);
  }

  public void swap(int nums[], int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
  }

  public void reverse(int nums[], int i, int j) {
    while (i < j) {
      swap(nums, i++, j--);
    }
  }
}