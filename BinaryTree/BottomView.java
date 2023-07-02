import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Solution {

  class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  class Pair {
    Node node;
    int hd;

    Pair(Node node, int hd) {
      this.node = node;
      this.hd = hd;
    }

  }

  public ArrayList<Integer> bottomView(Node root) {
    ArrayList<Integer> list = new ArrayList<>();

    if (root == null)
      return list;

    Map<Integer, Integer> map = new TreeMap<>();
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(root, 0));

    while (!q.isEmpty()) {
      Pair item = q.poll();
      int hd = item.hd;
      Node temp = item.node;

      map.put(hd, temp.data);
      if (temp.left != null)
        q.add(new Pair(temp.left, hd - 1));
      if (temp.right != null)
        q.add(new Pair(temp.right, hd + 1));
    }

    for (int x : map.keySet()) {
      list.add(map.get(x));
    }

    return list;
  }
}