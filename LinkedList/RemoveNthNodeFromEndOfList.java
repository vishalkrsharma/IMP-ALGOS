class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode trav = new ListNode(0);
    trav.next = head;

    ListNode fast = trav;
    ListNode slow = trav;

    for (int i = 0; i < n + 1; i++) {
      fast = fast.next;
    }

    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }

    slow.next = slow.next.next;

    return trav.next;
  }
}