class Solution {
  public int maxProfit(int[] prices) {
    int min = Integer.MAX_VALUE;
    int max = 0;

    for (int i = 0; i < prices.length; i++) {

      // check for min price to buy
      min = Math.min(min, prices[i]);

      // calculate max difference b/w buy and sell price
      max = Math.max(max, prices[i] - min);
    }

    return max;
  }
}