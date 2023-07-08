import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    Set<String> st = new HashSet<String>();
    int len = wordList.size();
    for (int i = 0; i < len; i++) {
      st.add(wordList.get(i));
    }

    Queue<ArrayList<String>> q = new LinkedList<>();
    ArrayList<String> ls = new ArrayList<>();
    ls.add(beginWord);
    q.add(ls);
    ArrayList<String> usedOnLevel = new ArrayList<>();
    usedOnLevel.add(beginWord);
    int level = 0;

    List<List<String>> ans = new ArrayList<>();
    int cnt = 0;

    while (!q.isEmpty()) {
      cnt++;
      ArrayList<String> vec = q.peek();
      q.remove();

      if (vec.size() > level) {
        level++;
        for (String it : usedOnLevel) {
          st.remove(it);
        }
      }

      String word = vec.get(vec.size() - 1);

      if (word.equals(endWord)) {

        if (ans.size() == 0) {
          ans.add(vec);
        } else if (ans.get(0).size() == vec.size()) {
          ans.add(vec);
        }
      }
      for (int i = 0; i < word.length(); i++) {
        for (char c = 'a'; c <= 'z'; c++) {
          char replacedCharArray[] = word.toCharArray();
          replacedCharArray[i] = c;
          String replacedWord = new String(replacedCharArray);
          if (st.contains(replacedWord) == true) {
            vec.add(replacedWord);
            ArrayList<String> temp = new ArrayList<>(vec);
            q.add(temp);
            usedOnLevel.add(replacedWord);
            vec.remove(vec.size() - 1);
          }
        }

      }
    }
    return ans;
  }
}