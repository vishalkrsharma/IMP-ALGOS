// reverse the last half of linked list
// keep pointer at start and middle of linked list
// check eah node to be equal
class Solution {
  public boolean isPalindrome(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    slow.next = reverse(slow.next);

    slow = slow.next;

    fast = head;

    while (slow != null) {
      if (slow.val != fast.val)
        return false;
      slow = slow.next;
      fast = fast.next;
    }

    return true;
  }

  public ListNode reverse(ListNode head) {

    ListNode prev = null;

    while (head != null) {
      ListNode nxt = head.next;
      head.next = prev;
      prev = head;
      head = nxt;
    }

    return prev;

  }
}