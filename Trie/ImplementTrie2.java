class Node {
  Node links[] = new Node[26];
  int cntEndWith = 0;
  int cntPrefix = 0;

  public Node() {
  }

  boolean containsKey(char ch) {
    return links[ch - 'a'] != null;
  }

  void put(char ch, Node node) {
    links[ch - 'a'] = node;
  }

  Node get(char ch) {
    return links[ch - 'a'];
  }

  void increaseEnd() {
    cntEndWith++;
  }

  void increasePrefix() {
    cntPrefix++;
  }

  void deleteEnd() {
    cntEndWith--;
  }

  void reducePrefix() {
    cntPrefix--;
  }

  int getEnd() {
    return cntEndWith;
  }

  int getPrefix() {
    return cntPrefix;
  }
}

class Trie {

  Node root;

  public Trie() {
    root = new Node();
  }

  public void insert(String word) {
    Node node = root;

    for (int i = 0; i < word.length(); i++) {
      char curr = word.charAt(i);
      if (!node.containsKey(curr)) {
        node.put(curr, new Node());
      }
      node = node.get(curr);
      node.increasePrefix();
    }
    node.increaseEnd();
  }

  public int countWordsEqualTo(String word) {
    Node node = root;

    for (int i = 0; i < word.length(); i++) {
      char curr = word.charAt(i);
      if (node.containsKey(curr)) {
        node = node.get(curr);
      } else {
        return 0;
      }
    }

    return node.getEnd();
  }

  public int countWordsStartingWith(String word) {
    Node node = root;

    for (int i = 0; i < word.length(); i++) {
      char curr = word.charAt(i);
      if (node.containsKey(curr)) {
        node = node.get(curr);
      } else {
        return 0;
      }
    }
    return node.getPrefix();
  }

  public void erase(String word) {
    Node node = root;

    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (node.containsKey(ch)) {
        node = node.get(ch);
        node.reducePrefix();
      } else {
        return;
      }
    }

    node.deleteEnd();
  }
}