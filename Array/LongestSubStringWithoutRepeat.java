import java.util.HashMap;

class Solution {
  public int lengthOfLongestSubstring(String s) {
    int r = 0, l = 0;
    HashMap<Character, Integer> map = new HashMap<>();
    int len = 0;

    while (r < s.length()) {
      if (map.containsKey(s.charAt(r))) {
        l = Math.max(map.get(s.charAt(r)) + 1, l);
      }

      map.put(s.charAt(r), r);
      len = Math.max(len, r - l + 1);
      r++;
    }

    return len;

  }
}