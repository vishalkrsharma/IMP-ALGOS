// extend the long list by(difference in lingth between two lists) then linear check
public class Solution1 {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode a = headA, b = headB;

    int l1 = 0, l2 = 0;

    while (a != null) {
      l1++;
      a = a.next;
    }

    while (b != null) {
      l2++;
      b = b.next;
    }

    int diff = l1 - l2;
    a = headA;
    b = headB;

    if (diff < 0) {
      for (int i = 0; i < Math.abs(diff); i++) {
        b = b.next;
      }
    } else {
      for (int i = 0; i < diff; i++) {
        a = a.next;
      }
    }

    while (a != null && b != null) {
      if (a == b) {
        return a;
      }

      a = a.next;
      b = b.next;
    }

    return null;
  }
}

public class Solution2 {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null)
      return null;

    ListNode a = headA, b = headB;

    while (a != b) {
      a = a == null ? headB : a.next;
      b = b == null ? headA : b.next;
    }

    return a;
  }
}