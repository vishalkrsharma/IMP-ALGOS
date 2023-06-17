class Solution {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode temp = new ListNode(0);
    ListNode curr = temp;

    while (list1 != null && list2 != null) {
      if (list1.val <= list2.val) {
        curr.next = list1;
        list1 = list1.next;
        curr = curr.next;
      } else {
        curr.next = list2;
        list2 = list2.next;
        curr = curr.next;
      }
    }

    while (list1 != null) {
      curr.next = list1;
      list1 = list1.next;
      curr = curr.next;
    }

    while (list2 != null) {
      curr.next = list2;
      list2 = list2.next;
      curr = curr.next;
    }

    return temp.next;
  }
}