import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
  class Pair {
    String word;
    int steps;

    Pair(String word, int steps) {
      this.word = word;
      this.steps = steps;
    }
  }

  public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(startWord, 1));
    Set<String> set = new HashSet<>();
    int len = wordList.length;

    for (int i = 0; i < len; i++) {
      set.add(wordList[i]);
    }

    set.remove(startWord);

    while (!q.isEmpty()) {
      String word = q.peek().word;
      int steps = q.peek().steps;
      q.remove();

      if (word.equals(targetWord) == true)
        return steps;

      for (int i = 0; i < word.length(); i++) {
        for (char ch = 'a'; ch <= 'z'; ch++) {
          char replacedCharArray[] = word.toCharArray();
          replacedCharArray[i] = ch;
          String replacedWord = new String(replacedCharArray);

          if (set.contains(replacedWord) == true) {
            set.remove(replacedWord);
            q.add(new Pair(replacedWord, steps + 1));
          }
        }
      }
    }

    return 0;
  }
}