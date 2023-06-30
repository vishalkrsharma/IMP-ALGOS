class Solution {
  public ListNode rotateRight(ListNode head, int k) {

    if (head == null || head.next == null || k == 0)
      return head;

    ListNode ptr = head, ans;
    int c = 1;
    while (ptr.next != null) {
      ptr = ptr.next;
      c++;
    }

    k = k % c;
    ptr.next = head;
    k = c - k;

    while (k-- > 0) {
      ptr = ptr.next;
    }

    head = ptr.next;
    ptr.next = null;

    return head;

  }
}