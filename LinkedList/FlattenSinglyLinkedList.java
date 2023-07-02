class Solution {

  class Node {
    int data;
    Node next;
    Node bottom;

    Node(int d) {
      data = d;
      next = null;
      bottom = null;
    }
  }

  Node merge(Node a, Node b) {
    Node temp = new Node(0);
    Node res = temp;

    while (a != null && b != null) {
      if (a.data < b.data) {
        temp.bottom = a;
        a = a.bottom;
        temp = temp.bottom;
      } else {
        temp.bottom = b;
        b = b.bottom;
        temp = temp.bottom;
      }
    }

    if (a != null) {
      temp.bottom = a;
    } else if (b != null) {
      temp.bottom = b;
    }

    return res.bottom;
  }

  Node flatten(Node root) {
    if (root == null || root.next == null)
      return root;

    root.next = flatten(root.next);

    root = merge(root, root.next);

    return root;
  }
}